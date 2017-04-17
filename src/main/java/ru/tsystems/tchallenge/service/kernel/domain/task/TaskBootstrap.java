package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.domain.employee.Employee;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImage;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.content.TaskImageContent;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.content.TaskImageContentRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.format.TaskImageFormat;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.format.TaskImageFormatBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.format.TaskImageFormatRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.input.TaskInput;
import ru.tsystems.tchallenge.service.kernel.domain.task.option.TaskOption;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategory;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategoryBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategoryRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficulty;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectation;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectationBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectationRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.ownership.TaskOwnership;
import ru.tsystems.tchallenge.service.kernel.domain.task.ownership.TaskOwnershipBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.ownership.TaskOwnershipRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippet;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyle;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyleBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyleRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.status.TaskStatusBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.status.TaskStatusRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.workflow.TaskWorkflow;
import ru.tsystems.tchallenge.service.kernel.domain.task.workflow.TaskWorkflowBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.workflow.TaskWorkflowRepository;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.OrdinalEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskBootstrap extends OrdinalEntityBootstrap<Task> {

    @Autowired
    private AccountBootstrap accountBootstrap;

    @Autowired
    private TaskCategoryBootstrap categoryBootstrap;

    @Autowired
    private TaskExpectationBootstrap expectationBootstrap;

    @Autowired
    private TaskDifficultyBootstrap difficultyBootstrap;

    @Autowired
    private TaskStatusBootstrap statusBootstrap;

    @Autowired
    private TaskWorkflowBootstrap workflowBootstrap;

    @Autowired
    private TaskOwnershipBootstrap ownershipBootstrap;

    @Autowired
    private TaskImageFormatBootstrap imageFormatBootstrap;

    @Autowired
    private TaskSnippetStyleBootstrap snippetStyleBootstrap;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TaskRepository taskRepository;

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
    private TaskSnippetStyleRepository snippetStyleRepository;

    @Autowired
    private TaskImageContentRepository imageContentRepository;

    @Override
    protected void collectEntities(final Collection<Task> tasks) {
        tasks.add(seattleTask());
        tasks.add(jarTask());
        tasks.add(imageTask());
        tasks.add(snippetTask());
    }

    @Override
    protected GenericEntityRepository<Task, Long> getRepository() {
        return taskRepository;
    }

    private Task seattleTask() {
        final Task task = new Task();
        task.setTitle("Работа В Сиэттле.");
        task.setQuestion("Сколько нужно человек, чтобы вымыть все окна в Сиэттле?");
        task.setStatus(statusRepository.findById("CREATED"));
        task.setComplexity(5);
        task.getCategories().addAll(categories("COMMON"));
        task.setDifficulty(difficulty("EASY"));
        task.setExpectation(expectation("SMALLINPUT"));
        task.setOwnership(ownership("PUBLIC"));
        task.setWorkflow(workflow("MACHINE"));
        task.setCreatedBy(petrov());
        task.getAuthors().add(petrov());
        task.getAuthors().add(kuznetcov());
        task.setInput(input("4", "Просто так"));
        return task;
    }

    private Task jarTask() {
        final Task task = new Task();
        task.setTitle("Кто здесь 'Номер Первый'?");
        task.setQuestion("Сколько классов с методом public static void main() может быть помещено в один Jar-файл?");
        task.setStatus(statusRepository.findById("APPROVED"));
        task.setComplexity(5);
        task.getCategories().addAll(categories("JAVA"));
        task.setDifficulty(difficulty("EASY"));
        task.setExpectation(expectation("SINGLESELECT"));
        task.setOwnership(ownership("PUBLIC"));
        task.setWorkflow(workflow("MACHINE"));
        task.setCreatedBy(petrov());
        task.getAuthors().add(petrov());
        task.getAuthors().add(kuznetcov());
        task.getOptions().add(option("A", "Только один класс.", 0, ""));
        task.getOptions().add(option("B", "По одному классу в каждом пакете.", 0, ""));
        task.getOptions().add(option("C", "Сколь угодно много классов.", 1, ""));
        task.getOptions().add(option("D", "Сколь угодно много классов, если каждый из них записан в манифесте.", 0, ""));
        return task;
    }

    private Task imageTask() {
        final Task task = new Task();
        task.setTitle("Задача с рисунками");
        task.setQuestion("В этой задаче использованы рисунки, все верно?");
        task.setStatus(statusRepository.findById("APPROVED"));
        task.setComplexity(5);
        task.getCategories().addAll(categories("COMMON"));
        task.setDifficulty(difficulty("EASY"));
        task.setExpectation(expectation("SINGLESELECT"));
        task.setOwnership(ownership("PUBLIC"));
        task.setWorkflow(workflow("MACHINE"));
        task.setCreatedBy(petrov());
        task.getAuthors().add(petrov());
        task.getAuthors().add(kuznetcov());
        task.getOptions().add(option("A", "Да.", 1, ""));
        task.getOptions().add(option("B", "Нет.", 0, ""));
        task.getImages().add(image(1, "GIF"));
        task.getImages().add(image(2, "JPEG"));
        task.getImages().add(image(3, "PNG"));
        return task;
    }

    private Task snippetTask() {
        final Task task = new Task();
        task.setTitle("Задача с кодом");
        task.setQuestion("В этой задаче использованы отрывки кода, все верно?");
        task.setStatus(statusRepository.findById("APPROVED"));
        task.setComplexity(5);
        task.getCategories().addAll(categories("COMMON"));
        task.setDifficulty(difficulty("EASY"));
        task.setExpectation(expectation("SINGLESELECT"));
        task.setOwnership(ownership("PUBLIC"));
        task.setWorkflow(workflow("MACHINE"));
        task.setCreatedBy(petrov());
        task.getAuthors().add(petrov());
        task.getAuthors().add(kuznetcov());
        task.getOptions().add(option("A", "Да.", 1, ""));
        task.getOptions().add(option("B", "Нет.", 0, ""));
        task.getSnippets().add(snippet(1, "JAVA"));
        task.getSnippets().add(snippet(2, "CONSOLE"));
        return task;
    }

    private Employee petrov() {
        return employee("ivan.sidorov@some-email.com");
    }

    private Employee kuznetcov() {
        return employee("ivan.sidorov@some-email.com");
    }

    private Employee employee(final String login) {
        return accountRepository.findByLogin(login).getEmployee();
    }

    private Collection<TaskCategory> categories(final String... ids) {
        return categoryRepository.findAllById(Arrays.asList(ids));
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
                                final String style) {
        final TaskSnippet snippet = new TaskSnippet();
        snippet.setContent("some code snippet here");
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
