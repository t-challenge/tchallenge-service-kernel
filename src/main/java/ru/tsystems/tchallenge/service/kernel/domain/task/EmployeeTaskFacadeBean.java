package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.domain.employee.Employee;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategory;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategoryRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficulty;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectation;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectationRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImage;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.content.TaskImageContent;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.content.TaskImageContentRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.format.TaskImageFormat;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.format.TaskImageFormatRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.input.TaskInput;
import ru.tsystems.tchallenge.service.kernel.domain.task.mindflow.TaskMindflowRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.option.TaskOption;
import ru.tsystems.tchallenge.service.kernel.domain.task.ownership.TaskOwnership;
import ru.tsystems.tchallenge.service.kernel.domain.task.ownership.TaskOwnershipRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippet;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyle;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyleRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.status.TaskStatusRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.workflow.TaskWorkflow;
import ru.tsystems.tchallenge.service.kernel.domain.task.workflow.TaskWorkflowRepository;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

@FacadeService
public class EmployeeTaskFacadeBean extends GenericFacade implements EmployeeTaskFacade {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeTaskMapper taskMapper;

    @Override
    public EmployeeTaskInfo get(final Long id) {
        return info(byId(id));
    }

    @Override
    public SearchInfo<EmployeeTaskInfo> getPage(final EmployeeTaskPageInvoice invoice) {
        final PageRequest pageRequest = new PageRequest(0, 10);
        final Page<Task> page = taskRepository.findPage(pageRequest);
        final SearchInfo<EmployeeTaskInfo> pageInfo = new SearchInfo<>();
        pageInfo.setSerial(1);
        pageInfo.setSize(10);
        pageInfo.setTotal(page.getTotalPages());
        pageInfo.setItems(page.getContent().stream().map(this::info).collect(Collectors.toList()));
        return pageInfo;
    }

    public EmployeeTaskInfo create(final EmployeeTaskInvoiceBlank invoiceBlank) {
        final AuthenticationInfo authentication = this.getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final AccountInfo account = authentication.getAccount();
        if (account.getEmployee() == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final Task task = taskMock(invoiceBlank, accountRepository.findByLogin(account.getLogin()));
        taskRepository.save(task);
        return info(task);
    }

    public EmployeeTaskInfo update(final EmployeeTaskInvoiceUpdate invoiceUpdate) {
        throw new UnsupportedOperationException();
    }

    private EmployeeTaskInfo info(final Task task) {
        return taskMapper.info(task);
    }

    private Task byId(final Long id) {
        return taskRepository.findById(id);
    }

    // --------------------------------------------------

    @Autowired
    private TaskCategoryRepository categoryRepository;

    @Autowired
    private TaskDifficultyRepository difficultyRepository;

    @Autowired
    private TaskExpectationRepository expectationRepository;

    @Autowired
    private TaskStatusRepository statusRepository;

    @Autowired
    private TaskWorkflowRepository workflowRepository;

    @Autowired
    private TaskOwnershipRepository ownershipRepository;

    @Autowired
    private TaskImageFormatRepository imageFormatRepository;

    @Autowired
    private TaskMindflowRepository mindflowRepository;

    @Autowired
    private TaskSnippetStyleRepository snippetStyleRepository;

    @Autowired
    private TaskImageContentRepository imageContentRepository;

    private Task taskMock(EmployeeTaskInvoiceBlank blank, Account account) {
        final Task task = new Task();
        task.setTitle(blank.getTitle());
        task.setQuestion(blank.getQuestion());
        task.setStatus(statusRepository.findById("CREATED"));
        task.setComplexity(blank.getComplexity());
        task.getCategories().addAll(categories(blank.getCategories()));
        task.setDifficulty(difficulty(blank.getDifficulty()));
        task.setExpectation(expectation(blank.getExpectation()));
        task.setOwnership(ownership(blank.getOwnership()));
        task.setWorkflow(workflow(blank.getWorkflow()));
        task.setCreatedBy(account.getEmployee());
        task.getAuthors().add(account.getEmployee());
        if (blank.getInput() != null) {
            task.setInput(input(blank.getInput().getContent(), blank.getInput().getExplanation()));
        }
        if (blank.getOptions() != null) {
            blank.getOptions().stream().forEach(o -> {
                task.getOptions().add(option(o.getTextcode(), o.getContent(), o.getCorrect() ? 1 : 0, o.getExplanation()));
            });
        }
        if (blank.getSnippets() != null) {
            blank.getSnippets().stream().forEach(s -> {
                task.getSnippets().add(snippet(s.getStance(), s.getContent(), s.getStyle()));
            });
        }
        task.setMindflow(mindflowRepository.findById("ANALYSES"));
        return task;
    }

    private Employee account() {
        return null;
    }

    private Collection<TaskCategory> categories(final Collection<String> ids) {
        return categoryRepository.findAllById(ids);
    }

    private TaskDifficulty difficulty(final String id) {
        return difficultyRepository.findById(id);
    }

    private TaskExpectation expectation(final String id) {
        return expectationRepository.findById(id);
    }

    private TaskWorkflow workflow(final String id) {
        return workflowRepository.findById(id);
    }

    private TaskOwnership ownership(final String id) {
        return ownershipRepository.findById(id);
    }

    private TaskInput input(final String content,
                            final String explanation) {
        final TaskInput input = new TaskInput();
        input.setContent(content);
        input.setExplanation(explanation);
        return input;
    }

    private TaskOption option(final String textcode,
                              final String content,
                              final Integer correct,
                              final String explanation) {
        final TaskOption option = new TaskOption();
        option.setTextcode(textcode);
        option.setContent(content);
        option.setCorrect(correct);
        option.setExplanation(explanation);
        return option;
    }

    private TaskImage image(final Integer stance,
                            final String format) {
        final TaskImage image = new TaskImage();
        image.setContent(imageContent("some binary data"));
        image.setDescription("some description");
        image.setFormat(imageFormat(format));
        image.setStance(stance);
        image.setHeight(100);
        image.setWidth(100);
        return image;
    }

    private TaskSnippet snippet(final Integer stance,
                                final String content,
                                final String style) {
        final TaskSnippet snippet = new TaskSnippet();
        snippet.setContent(content);
        snippet.setStyle(snippetStyle(style));
        snippet.setStance(stance);
        return snippet;
    }

    private TaskImageFormat imageFormat(final String id) {
        return imageFormatRepository.findById(id);
    }

    private TaskSnippetStyle snippetStyle(final String id) {
        return snippetStyleRepository.findById(id);
    }

    private String imageContent(final String binarySample) {
        final TaskImageContent content = new TaskImageContent();
        content.setBinaryData(binarySample.getBytes());
        imageContentRepository.save(content);
        return content.getId();
    }
}
