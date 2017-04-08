package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.domain.employee.EmployeeMapper;
import ru.tsystems.tchallenge.service.kernel.domain.employee.EmployeeRepository;
import ru.tsystems.tchallenge.service.kernel.domain.solution.input.SolutionInputMapperBean;
import ru.tsystems.tchallenge.service.kernel.domain.solution.option.SolutionOptionMapper;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategory;
import ru.tsystems.tchallenge.service.kernel.domain.task.status.TaskStatusRepository;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.generic.page.PageInfo;

@FacadeService
public class TaskFacadeBean extends GenericFacade {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SolutionInputMapperBean solutionInputMapper;

    @Autowired
    private SolutionOptionMapper solutionOptionMapper;

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    public TaskInfo create(final TaskInvoice invoice) {
        return saveAndInfo(fromInvoice(invoice));
    }

    public TaskInfo getById(final Long id) {
        return info(byId(id));
    }

    public PageInfo<TaskInfo> getPage(final TaskPageInvoice invoice) {
        final PageInfo<TaskInfo> page = new PageInfo<>();
        page.setItems(taskRepository.findAll().stream().map(this::info).collect(Collectors.toList()));
        return page;
    }

    public TaskInfo update(final TaskUpdateInvoice invoice) {
        return saveAndInfo(mergeInvoice(byId(invoice.getId()), invoice));
    }

    public TaskInfo updateStatus(final TaskStatusUpdateInvoice invoice) {
        return saveAndInfo(mergeStatusInvoice(byId(invoice.getId()), invoice));
    }

    private TaskInfo saveAndInfo(final Task task) {
        return info(taskRepository.save(task));
    }

    private Task byId(final Long id) {
        return taskRepository.findById(id);
    }

    private Task fromInvoice(final TaskInvoice invoice) {
        final Task task = new Task();
        task.setTitle(invoice.getTitle());
        task.setIntroduction(invoice.getIntroduction());
        task.setQuestion(invoice.getQuestion());
        task.setStatus(taskStatusRepository.findById("CREATED"));
        return task;
    }

    private Task mergeInvoice(final Task task, final TaskUpdateInvoice invoice) {
        task.setTitle(invoice.getTitle());
        task.setIntroduction(invoice.getIntroduction());
        task.setQuestion(invoice.getQuestion());
        return task;
    }

    private Task mergeStatusInvoice(final Task task, final TaskStatusUpdateInvoice invoice) {
        task.setStatus(taskStatusRepository.findById(invoice.getStatus()));
        return task;
    }

    private TaskInfo info(final Task task) {
        final TaskInfo info = new TaskInfo();
        info.setId(task.getId());
        info.setTitle(task.getTitle());
        info.setIntroduction(task.getIntroduction());
        info.setQuestion(task.getQuestion());
        info.setStatus(task.getStatus().getId());
        info.setCategories(task.getCategories().stream().map(TaskCategory::getId).collect(Collectors.toList()));
        info.setDifficulty(task.getDifficulty().getId());
        info.setExpectation(task.getExpectation().getId());
        if (task.getSolutionInput() != null) {
            info.setSolutionInput(solutionInputMapper.info(task.getSolutionInput()));
        }
        info.setSolutionOptions(task.getSolutionOptions().stream().map(solutionOptionMapper::infoComplete).collect(Collectors.toList()));
        info.setAuthors(task.getAuthors().stream().map(employeeMapper::infoShort).collect(Collectors.toList()));
        info.setCreatedBy(employeeMapper.infoShort(task.getCreatedBy()));
        info.setCreatedAt(task.getCreatedAt());
        info.setModifiedAt(task.getModifiedAt());
        return info;
    }
}
