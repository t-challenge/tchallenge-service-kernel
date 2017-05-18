package ru.tsystems.tchallenge.service.kernel.domain.workbook;

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
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.hibernate.jpa.criteria.path.MapKeyHelpers;
import org.hibernate.jpa.internal.metamodel.SingularAttributeImpl;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.domain.assignment.Assignment;
import ru.tsystems.tchallenge.service.kernel.domain.assignment.AssignmentInfo;
import ru.tsystems.tchallenge.service.kernel.domain.assignment.status.AssignmentStatusRepository;
import ru.tsystems.tchallenge.service.kernel.domain.event.Event;
import ru.tsystems.tchallenge.service.kernel.domain.event.EventRepository;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.MaturityRepository;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.Specialization;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.SpecializationRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.CandidateTaskMapper;
import ru.tsystems.tchallenge.service.kernel.domain.task.Task;
import ru.tsystems.tchallenge.service.kernel.domain.task.TaskRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.option.TaskOption;
import ru.tsystems.tchallenge.service.kernel.domain.workbook.status.WorkbookStatusRepository;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;
import ru.tsystems.tchallenge.service.kernel.validation.contract.ContractValidationException;
import ru.tsystems.tchallenge.service.kernel.validation.contract.PropertyContractViolationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.resource.ResourceUnavailableViolationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.resource.ResourceUnknownViolationInfo;

@FacadeService
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
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    @Autowired
    private AssignmentStatusRepository assignmentStatusRepository;

    @Override
    public WorkbookInfo create(final WorkbookInvoice invoice) {
        final AuthenticationInfo authentication = this.getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final AccountInfo account = authentication.getAccount();
        if (account.getCandidate() == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final Workbook workbook = new Workbook();
        final Event event = eventRepository.findByTextcode(invoice.getEvent());
        if (event == null) {
            throw new ContractValidationException(Collections.singleton(new ResourceUnavailableViolationInfo("event", invoice.getEvent())));
        }
        if (!event.getMaturity().getId().equals(invoice.getMaturity())) {
            throw new ContractValidationException(Collections.singleton(new PropertyContractViolationInfo("maturity", invoice.getMaturity(), "no such maturity")));
        }
        if (!event.getSpecializations().stream().map(Specialization::getId).collect(Collectors.toList()).contains(invoice.getSpecialization())) {
            throw new ContractValidationException(Collections.singleton(new PropertyContractViolationInfo("specialization", invoice.getSpecialization(), "no such specialization")));
        }
        if (!event.getStatus().getId().equals("APPROVED")) {
            throw new ContractValidationException(Collections.singleton(new PropertyContractViolationInfo("event", invoice.getEvent(), "event status is not acceptable")));
        }
        if (event.getSince() != null && event.getSince().isAfter(Instant.now())
                || event.getUntil() != null && event.getUntil().isBefore(Instant.now())) {
            throw new ContractValidationException(Collections.singleton(new PropertyContractViolationInfo("event", invoice.getEvent(), "event time period is not acceptable")));
        }
        workbook.setCandidate(accountRepository.findByLogin(account.getLogin()).getCandidate());
        workbook.setEvent(event);
        workbook.setSpecialization(specializationRepository.findById(invoice.getSpecialization()));
        workbook.setMaturity(maturityRepository.findById(invoice.getMaturity()));
        workbook.setStatus(statusRepository.findById("CREATED"));
        workbook.setScore(0);
        workbook.setMaxScore(0);
        final Collection<Assignment> assignments = new ArrayList<>();
        taskRepository.findAll().forEach(task -> {
            final Assignment assignment = new Assignment();
            assignment.setMaxScore(100);
            assignment.setScore(0);
            assignment.setTask(task);
            assignment.setStance(assignments.size() + 1);
            assignment.setStatus(assignmentStatusRepository.findById("CREATED"));
            assignment.setWorkbook(workbook);
            assignments.add(assignment);
            workbook.setMaxScore(workbook.getMaxScore() + assignment.getMaxScore());
        });
        workbook.setAssignments(assignments);
        workbookRepository.save(workbook);
        return info(workbook);
    }

    @Override
    public WorkbookInfo get(final Long id) {
        final AuthenticationInfo authentication = this.getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final Workbook workbook = workbookRepository.findById(id);
        final AccountInfo account = authentication.getAccount();
        if (account.getEmployee() == null && !account.getLogin().equals(workbook.getCandidate().getAccount().getLogin())) {
            accessValidationExceptionEmitter.unauthorized();
        }
        return info(workbook);
    }

    @RequestMapping(method = RequestMethod.GET)
    public SearchInfo<WorkbookInfo> getPage(final WorkbookPageInvoice invoice) {
        final AuthenticationInfo authentication = getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
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
        final AuthenticationInfo authentication = this.getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final Workbook workbook = workbookRepository.findById(invoice.getId());
        final AccountInfo account = authentication.getAccount();
        if (account.getEmployee() == null && !account.getLogin().equals(workbook.getCandidate().getAccount().getLogin())) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final String statusCurrent = workbook.getStatus().getId();
        final String statusInvoice = invoice.getStatus();
        if (statusInvoice.equals("CREATED")) {
            throw new ContractValidationException(Collections.singleton(new PropertyContractViolationInfo("status", statusInvoice, "can not set created")));
        }
        if ((statusInvoice.equals("SUBMITTED") || statusInvoice.equals("DISCARDED"))
                && !(statusCurrent.equals("CREATED"))) {
            throw new ContractValidationException(Collections.singleton(new PropertyContractViolationInfo("status", statusInvoice, "can not be submitted or discarded")));
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
    private CandidateTaskMapper candidateTaskMapper;

    private AssignmentInfo assignmentInfo(final Assignment assignment) {
        final AssignmentInfo info = new AssignmentInfo();
        info.setId(assignment.getId());
        info.setStance(assignment.getStance());
        info.setTask(candidateTaskMapper.infoClosed(assignment.getTask()));
        info.setScore(assignment.getScore());
        info.setMaxScore(assignment.getMaxScore());
        info.setScore(assignment.getScore());
        info.setInput(assignment.getInput());
        info.setStatus(assignment.getStatus().getId());
        return info;
    }
}
