package ru.tchallenge.service.kernel.domain.workbook;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.tchallenge.service.kernel.conventions.components.FacadeServiceComponent;
import ru.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tchallenge.service.kernel.domain.assignment.Assignment;
import ru.tchallenge.service.kernel.domain.assignment.AssignmentInfo;
import ru.tchallenge.service.kernel.domain.assignment.status.AssignmentStatusRepository;
import ru.tchallenge.service.kernel.domain.event.Event;
import ru.tchallenge.service.kernel.domain.event.EventRepository;
import ru.tchallenge.service.kernel.domain.maturity.MaturityRepository;
import ru.tchallenge.service.kernel.domain.specialization.Specialization;
import ru.tchallenge.service.kernel.domain.specialization.SpecializationRepository;
import ru.tchallenge.service.kernel.domain.task.Task;
import ru.tchallenge.service.kernel.domain.task.TaskMapper;
import ru.tchallenge.service.kernel.domain.task.TaskRepository;
import ru.tchallenge.service.kernel.domain.task.TaskSelectionInfo;
import ru.tchallenge.service.kernel.domain.task.TaskSelectionInvoice;
import ru.tchallenge.service.kernel.domain.task.TaskSelectionService;
import ru.tchallenge.service.kernel.domain.task.option.TaskOption;
import ru.tchallenge.service.kernel.domain.workbook.status.WorkbookStatusRepository;
import ru.tchallenge.service.kernel.generic.GenericFacade;
import ru.tchallenge.service.kernel.generic.page.SearchInfo;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tchallenge.service.kernel.utility.mail.MailInvoice;
import ru.tchallenge.service.kernel.utility.mail.MailService;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionProvider;
import ru.tchallenge.service.kernel.validation.contract.ContractValidationExceptionProvider;
import ru.tchallenge.service.kernel.validation.contract.ContractViolationInfo;
import ru.tchallenge.service.kernel.validation.contract.PropertyContractViolationInfo;
import ru.tchallenge.service.kernel.validation.resource.ResourceUnavailableViolationInfo;
import ru.tchallenge.service.kernel.validation.resource.ResourceValidationExceptionProvider;
import ru.tchallenge.service.kernel.validation.resource.ResourceViolationInfo;

@FacadeServiceComponent
public class WorkbookFacadeBean extends GenericFacade implements WorkbookFacade {

    @Autowired
    private WorkbookRepository workbookRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private MaturityRepository maturityRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private WorkbookStatusRepository statusRepository;

    @Autowired
    private AccessValidationExceptionProvider accessValidationExceptionProvider;

    @Autowired
    private AssignmentStatusRepository assignmentStatusRepository;

    @Autowired
    private TaskSelectionService taskSelectionService;

    @Autowired
    private ContractValidationExceptionProvider contractValidationExceptionProvider;

    @Autowired
    private ResourceValidationExceptionProvider resourceValidationExceptionProvider;

    @Override
    public WorkbookInfo create(final WorkbookInvoice invoice) {
        final AuthenticationInfo authentication = this.getAuthenticationContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionProvider.unauthorized();
        }
        final AccountInfo account = authentication.getAccount();
        if (account.getCandidate() == null) {
            accessValidationExceptionProvider.unauthorized();
        }
        final Workbook workbook = new Workbook();
        final Event event = eventRepository.findByTextcode(invoice.getEvent());
        if (event == null) {
            ResourceViolationInfo violation = new ResourceUnavailableViolationInfo("event", invoice.getEvent());
            throw resourceValidationExceptionProvider.exception(violation);
        }
        if (!event.getSpecializations().stream().map(Specialization::getId).collect(Collectors.toList()).contains(invoice.getSpecialization())) {
            ContractViolationInfo violation = new PropertyContractViolationInfo("specialization", invoice.getSpecialization(), "no such specialization");
            throw contractValidationExceptionProvider.exception(violation);
        }
        if (!event.getStatus().getId().equals("APPROVED")) {
            ContractViolationInfo violation = new PropertyContractViolationInfo("event", invoice.getEvent(), "event status is not acceptable");
            throw contractValidationExceptionProvider.exception(violation);
        }
        if (event.getSince() != null && event.getSince().isAfter(Instant.now())
                || event.getUntil() != null && event.getUntil().isBefore(Instant.now())) {
            ContractViolationInfo violation = new PropertyContractViolationInfo("event", invoice.getEvent(), "event time period is not acceptable");
            throw contractValidationExceptionProvider.exception(violation);
        }
        workbook.setCandidate(accountRepository.findByLogin(account.getLogin()).getCandidate());
        workbook.setEvent(event);
        workbook.setSpecialization(specializationRepository.findById(invoice.getSpecialization()));
        workbook.setMaturity(maturityRepository.findById(invoice.getMaturity()));
        workbook.setStatus(statusRepository.findById("CREATED"));
        workbook.setScore(0);
        workbook.setMaxScore(0);
        final TaskSelectionInfo taskSelection = taskSelection(event);
        final Collection<Assignment> assignments = new ArrayList<>();
        taskSelection.getIds().forEach(id -> {
            final Assignment assignment = new Assignment();
            assignment.setMaxScore(100);
            assignment.setScore(0);
            assignment.setTask(taskRepository.findById(id));
            assignment.setStance(assignments.size() + 1);
            assignment.setStatus(assignmentStatusRepository.findById("CREATED"));
            assignment.setWorkbook(workbook);
            assignments.add(assignment);
            workbook.setMaxScore(workbook.getMaxScore() + assignment.getMaxScore());
        });
        workbook.setAssignments(assignments);
        workbookRepository.save(workbook);
        final MailInvoice mailInvoice = new MailInvoice();
        mailInvoice.setTarget(account.getEmail());
        mailInvoice.setSubject(String.format("Создана Ваша рабочая тетрадь T-Challenge"));
        final String url = String.format(invoice.getFlashback(), workbook.getId());
        mailInvoice.setContent("<html><head><meta charset=\"UTF-8\"></head><body><h3>Создана Ваша рабочая тетрадь T-Challenge</h3>" +
                "<a href=\"" + url + "\">Воспользуйтесь этой ссылкой, чтобы пройти тест</a></body></html>");
        mailService.send(mailInvoice);
        return info(workbook);
    }

    @Autowired
    private MailService mailService;

    @Override
    public WorkbookInfo get(final Long id) {
        final AuthenticationInfo authentication = this.getAuthenticationContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionProvider.unauthorized();
        }
        final Workbook workbook = workbookRepository.findById(id);
        final AccountInfo account = authentication.getAccount();
        if (account.getEmployee() == null && !account.getLogin().equals(workbook.getCandidate().getAccount().getLogin())) {
            accessValidationExceptionProvider.unauthorized();
        }
        return info(workbook);
    }

    @RequestMapping(method = RequestMethod.GET)
    public SearchInfo<WorkbookInfo> getPage(final WorkbookPageInvoice invoice) {
        final AuthenticationInfo authentication = getAuthenticationContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionProvider.unauthorized();
        }
        final String login = authentication.getAccount().getLogin();
        final Page<Workbook> page;
        switch (authentication.getAccount().getRealm()) {
            case "CANDIDATE":
                final PageRequest candidatePageRequest = new PageRequest(invoice.getStance() - 1, invoice.getSize());
                page = workbookRepository.findPage(login, "%", Arrays.asList("CREATED", "APPROVED", "DISCARDED", "SUBMITTED", "ASSESSED"), candidatePageRequest);
                break;
            case "EMPLOYEE":
                final PageRequest employeePageRequest = new PageRequest(invoice.getStance() - 1, invoice.getSize());
                page = workbookRepository.findPage("%", invoice.getEvent(), Arrays.asList("ASSESSED"), employeePageRequest);
                break;
            case "ROBOT":
                final PageRequest robotPageRequest = new PageRequest(invoice.getStance() - 1, invoice.getSize());
                page = workbookRepository.findPage("%", invoice.getEvent(), Arrays.asList("ASSESSED"), robotPageRequest);
                break;
            default:
                throw new UnsupportedOperationException();
        }
        SearchInfo<WorkbookInfo> searchInfo = new SearchInfo<>();
        searchInfo.setSize(page.getSize());
        searchInfo.setSerial(invoice.getStance());
        searchInfo.setTotal(page.getTotalPages());
        searchInfo.setItems(page.getContent().stream().map(this::info).collect(Collectors.toList()));
        return searchInfo;
    }

    @Override
    public WorkbookInfo update(final WorkbookInvoice invoice) {
        final AuthenticationInfo authentication = this.getAuthenticationContext().getAuthentication();
        if (authentication == null) {
            throw accessValidationExceptionProvider.unauthorized();
        }
        final Workbook workbook = workbookRepository.findById(invoice.getId());
        final AccountInfo account = authentication.getAccount();
        if (account.getEmployee() == null && !account.getLogin().equals(workbook.getCandidate().getAccount().getLogin())) {
            throw accessValidationExceptionProvider.unauthorized();
        }
        final String statusCurrent = workbook.getStatus().getId();
        final String statusInvoice = invoice.getStatus();
        if (statusInvoice.equals("CREATED")) {
            ContractViolationInfo violation = new PropertyContractViolationInfo("status", statusInvoice, "can not set created");
            throw contractValidationExceptionProvider.exception(violation);
        }
        if ((statusInvoice.equals("SUBMITTED") || statusInvoice.equals("DISCARDED"))
                && !(statusCurrent.equals("CREATED"))) {
            ContractViolationInfo violation = new PropertyContractViolationInfo("status", statusInvoice, "can not be submitted or discarded");
            throw contractValidationExceptionProvider.exception(violation);
        }
        workbook.setStatus(statusRepository.findById(invoice.getStatus()));
        if (invoice.getStatus().equals("SUBMITTED")) {
            workbook.setScore(0);
            workbook.getAssignments().forEach(assignment -> {
                assignment.setStatus(assignmentStatusRepository.findById("ASSESSED"));
                final String input = assignment.getInput();
                final Task task = assignment.getTask();
                boolean correct = false;
                if (assignment.getInput() == null) {
                    correct = false;
                } else if (task.getExpectation().getId().equals("SMALLINPUT")) {
                    if (input.equals(task.getInput().getContent())) {
                        correct = true;
                    }
                } else if (task.getExpectation().getId().equals("SINGLESELECT")) {
                    final Set<String> inputSet = new HashSet<String>(Arrays.asList(input.split(" ")));
                    boolean optionsCorrect = true;
                    for (TaskOption option : task.getOptions()) {
                        if (option.getCorrect() == 0 && inputSet.contains(option.getTextcode())) {
                            optionsCorrect = false;
                            break;
                        }
                        if (option.getCorrect() != 0 && !inputSet.contains(option.getTextcode())) {
                            optionsCorrect = false;
                            break;
                        }
                    }
                    correct = optionsCorrect;
                }
                assignment.setScore(correct ? assignment.getMaxScore() : 0);
                workbook.setScore(workbook.getScore() + assignment.getScore());
            });
            workbook.setStatus(statusRepository.findById("ASSESSED"));
        }
        workbookRepository.save(workbook);
        return info(workbook);
    }

    private WorkbookInfo info(final Workbook workbook) {
        final WorkbookInfo info = new WorkbookInfo();
        info.setId(workbook.getId());
        info.setMaxScore(workbook.getMaxScore());
        info.setStatus(workbook.getStatus().getId());
        info.setEvent(workbook.getEvent().getTextcode());
        info.setAssignments(workbook.getAssignments().stream().map(this::assignmentInfo).collect(Collectors.toList()));
        info.setScore(workbook.getScore());
        return info;
    }

    @Autowired
    private TaskMapper candidateTaskMapper;

    private AssignmentInfo assignmentInfo(final Assignment assignment) {
        final AssignmentInfo info = new AssignmentInfo();
        info.setId(assignment.getId());
        info.setStance(assignment.getStance());
        info.setTask(candidateTaskMapper.asInfoRestricted(assignment.getTask()));
        info.setScore(assignment.getScore());
        info.setMaxScore(assignment.getMaxScore());
        info.setScore(assignment.getScore());
        info.setInput(assignment.getInput());
        info.setStatus(assignment.getStatus().getId());
        return info;
    }

    private TaskSelectionInfo taskSelection(final Event event) {
        final TaskSelectionInvoice invoice = new TaskSelectionInvoice();
        invoice.setAmount(5);
        invoice.setCategories(Collections.singleton("JAVA"));
        return taskSelectionService.create(invoice);
    }
}
