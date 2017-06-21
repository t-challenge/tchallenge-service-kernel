package ru.tchallenge.service.kernel.domain.task;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ru.tchallenge.service.kernel.conventions.components.FacadeServiceComponent;
import ru.tchallenge.service.kernel.domain.account.Account;
import ru.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tchallenge.service.kernel.domain.employee.EmployeeInfo;
import ru.tchallenge.service.kernel.domain.task.category.TaskCategory;
import ru.tchallenge.service.kernel.domain.task.category.TaskCategoryRepository;
import ru.tchallenge.service.kernel.domain.task.difficulty.TaskDifficulty;
import ru.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyRepository;
import ru.tchallenge.service.kernel.domain.task.expectation.TaskExpectationRepository;
import ru.tchallenge.service.kernel.domain.task.family.TaskFamilyRepository;
import ru.tchallenge.service.kernel.domain.task.mindflow.TaskMindflowRepository;
import ru.tchallenge.service.kernel.domain.task.status.TaskStatusRepository;
import ru.tchallenge.service.kernel.domain.task.tags.TaskTagRepository;
import ru.tchallenge.service.kernel.domain.task.workflow.TaskWorkflowRepository;
import ru.tchallenge.service.kernel.generic.GenericFacade;
import ru.tchallenge.service.kernel.generic.page.SearchInfo;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionProvider;

@FacadeServiceComponent
public class TaskFacadeBean extends GenericFacade implements TaskFacade {

    @Autowired
    private TaskCategoryRepository categoryRepository;

    @Autowired
    private TaskDifficultyRepository difficultyRepository;

    @Autowired
    private TaskFamilyRepository familyRepository;

    @Autowired
    private TaskMindflowRepository mindflowRepository;

    @Autowired
    private TaskWorkflowRepository workflowRepository;

    @Autowired
    private TaskExpectationRepository expectationRepository;

    @Autowired
    private TaskTagRepository tagRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccessValidationExceptionProvider accessValidationExceptionProvider;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskStatusRepository statusRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private TaskValidator taskValidator;

    @Override
    public TaskInfoComplete get(final Long id) {
        authenticatedEmployee();
        return info(byId(id));
    }

    @Override
    public SearchInfo<TaskInfoComplete> search(final TaskSearchInvoice invoice) {
        final PageRequest pageRequest = pageRequest(invoice);
        final Page<Task> page = taskRepository.findPage(
                "%",
         //       tagRepository.findAll().stream().map(TaskTag::getId).collect(Collectors.toList()),
                categoryRepository.findAll().stream().map(TaskCategory::getId).collect(Collectors.toList()),
                difficultyRepository.findAll().stream().map(TaskDifficulty::getId).collect(Collectors.toList()),
                accountRepository.findAll().stream().map(Account::getLogin).collect(Collectors.toList()),
                pageRequest);
        final SearchInfo<TaskInfoComplete> pageInfo = new SearchInfo<>();
        pageInfo.setSerial(pageRequest.getPageNumber() + 1);
        pageInfo.setSize(pageRequest.getPageSize());
        pageInfo.setTotal(page.getTotalPages());
        pageInfo.setItems(page.getContent().stream().map(this::info).collect(Collectors.toList()));
        return pageInfo;
    }

    public TaskInfoComplete create(final TaskInvoice invoice) {
        final AccountInfo account = authenticatedEmployee();
        taskValidator.ensureForCreate(invoice);
        final Task task = taskMapper.asEntity(invoice);
        task.setStatus(statusRepository.findById("CREATED"));
        task.setCreatedBy(accountRepository.findByLogin(account.getLogin()).getEmployee());
        taskRepository.save(task);
        return info(task);
    }

    public TaskInfoComplete update(final TaskInvoice invoice) {
        authenticatedEmployee();
        taskValidator.ensureForUpdate(invoice);
        final Task task = byId(invoice.getId());
        taskMapper.asEntityMerged(task, invoice);
        taskRepository.save(task);
        return info(task);
    }

    @Override
    public TaskInfoComplete updateStatus(final TaskInvoice invoice) {
        authenticatedEmployee();
        taskValidator.ensureForUpdateStatus(invoice);
        final Task task = byId(invoice.getId());
        final String newStatus = invoice.getStatus();
        if (newStatus.equals("CREATED")) {
            throw new RuntimeException("can't set CREATED status");
        }
        task.setStatus(statusRepository.findById(newStatus));
        taskRepository.save(task);
        return info(task);
    }

    private TaskInfoComplete info(final Task task) {
        return taskMapper.asInfoComplete(task);
    }

    private Task byId(final Long id) {
        return taskRepository.findById(id);
    }

    private AccountInfo authenticatedEmployee(final String... roles) {
        final AuthenticationInfo authentication = this.getAuthenticationContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionProvider.unauthorized();
        }
        final AccountInfo account = authentication.getAccount();
        if (account == null) {
            accessValidationExceptionProvider.unauthorized();
        }
        final EmployeeInfo employee = account.getEmployee();
        if (employee == null) {
            accessValidationExceptionProvider.unauthorized();
        }
        if (roles.length > 0 && Arrays.asList(roles).stream().noneMatch(employee.getRoles()::contains)) {
            accessValidationExceptionProvider.unauthorized();
        }
        return account;
    }

    private PageRequest pageRequest(final TaskSearchInvoice invoice) {
        final int size = invoice.getSize() == null ? 10 : invoice.getSize();
        final int stance = invoice.getStance() == null ? 0 : invoice.getStance() - 1;
        return new PageRequest(stance, size);
    }
}
