package ru.tchallenge.service.kernel.domain.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.domain.account.AccountBootstrap;
import ru.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tchallenge.service.kernel.domain.employee.Employee;
import ru.tchallenge.service.kernel.domain.task.category.TaskCategory;
import ru.tchallenge.service.kernel.domain.task.category.TaskCategoryBootstrap;
import ru.tchallenge.service.kernel.domain.task.category.TaskCategoryRepository;
import ru.tchallenge.service.kernel.domain.task.difficulty.TaskDifficulty;
import ru.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyBootstrap;
import ru.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyRepository;
import ru.tchallenge.service.kernel.domain.task.expectation.TaskExpectation;
import ru.tchallenge.service.kernel.domain.task.expectation.TaskExpectationBootstrap;
import ru.tchallenge.service.kernel.domain.task.expectation.TaskExpectationRepository;
import ru.tchallenge.service.kernel.domain.task.image.TaskImage;
import ru.tchallenge.service.kernel.domain.task.image.content.TaskImageContent;
import ru.tchallenge.service.kernel.domain.task.image.content.TaskImageContentRepository;
import ru.tchallenge.service.kernel.domain.task.image.format.TaskImageFormat;
import ru.tchallenge.service.kernel.domain.task.image.format.TaskImageFormatBootstrap;
import ru.tchallenge.service.kernel.domain.task.image.format.TaskImageFormatRepository;
import ru.tchallenge.service.kernel.domain.task.input.TaskInput;
import ru.tchallenge.service.kernel.domain.task.mindflow.TaskMindflow;
import ru.tchallenge.service.kernel.domain.task.mindflow.TaskMindflowBootstrap;
import ru.tchallenge.service.kernel.domain.task.mindflow.TaskMindflowRepository;
import ru.tchallenge.service.kernel.domain.task.option.TaskOption;
import ru.tchallenge.service.kernel.domain.task.ownership.TaskOwnership;
import ru.tchallenge.service.kernel.domain.task.ownership.TaskOwnershipBootstrap;
import ru.tchallenge.service.kernel.domain.task.ownership.TaskOwnershipRepository;
import ru.tchallenge.service.kernel.domain.task.snippet.TaskSnippet;
import ru.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyle;
import ru.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyleBootstrap;
import ru.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyleRepository;
import ru.tchallenge.service.kernel.domain.task.status.TaskStatusBootstrap;
import ru.tchallenge.service.kernel.domain.task.status.TaskStatusRepository;
import ru.tchallenge.service.kernel.domain.task.workflow.TaskWorkflow;
import ru.tchallenge.service.kernel.domain.task.workflow.TaskWorkflowBootstrap;
import ru.tchallenge.service.kernel.domain.task.workflow.TaskWorkflowRepository;

@BootstrapComponent
public class TaskHeisenbugProviderBean {

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
    private TaskMindflowBootstrap mindflowBootstrap;

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
    private TaskMindflowRepository mindflowRepository;

    @Autowired
    private TaskOwnershipRepository ownershipRepository;

    @Autowired
    private TaskImageFormatRepository imageFormatRepository;

    @Autowired
    private TaskSnippetStyleRepository snippetStyleRepository;

    @Autowired
    private TaskImageContentRepository imageContentRepository;

    public Collection<Task> getTasks() {
        final Collection<Task> result = new ArrayList<>();
        result.add(task01());
        result.add(task02());
        result.add(task03());
        result.add(task04());
        result.add(task05());
        result.add(task06());
        result.add(task07());
        result.add(task08());
        result.add(task09());
        result.add(task10());
        return result;
    }

    private Task task01() {
        final Task result = new Task();
        result.setQuestion("Аббревиатура PDCA (в рамках процесса разработки ПО) расшифровывается как:");
        result.setStatus(statusRepository.findById("APPROVED"));
        result.setComplexity(5);
        result.getCategories().addAll(categories("JAVA", "TEST"));
        result.setDifficulty(difficulty("MEDIUM"));
        result.setExpectation(expectation("SINGLESELECT"));
        result.setOwnership(ownership("PUBLIC"));
        result.setMindflow(mindflow("FOUNDATIONS"));
        result.setWorkflow(workflow("MACHINE"));
        result.setCreatedBy(petrov());
        result.getAuthors().add(petrov());
        result.getAuthors().add(kuznetcov());
        result.getOptions().add(option("A", "Plan Do Check Act", 1, ""));
        result.getOptions().add(option("B", "Proceed Develop Check Act", 0, ""));
        result.getOptions().add(option("C", "Plan Debug Check Approve", 0, ""));
        result.getOptions().add(option("D", "Plan Do Correct Act", 0, ""));
        return result;
    }

    private Task task02() {
        final Task result = new Task();
        result.setQuestion("Имеется поле ввода возраста. По требованию допустимые значения от 18 до 71 включительно. Какие значения необходимо проверить, применив технику анализа граничных значений?");
        result.setStatus(statusRepository.findById("APPROVED"));
        result.setComplexity(5);
        result.getCategories().addAll(categories("JAVA", "TEST"));
        result.setDifficulty(difficulty("MEDIUM"));
        result.setExpectation(expectation("SINGLESELECT"));
        result.setOwnership(ownership("PUBLIC"));
        result.setMindflow(mindflow("FOUNDATIONS"));
        result.setWorkflow(workflow("MACHINE"));
        result.setCreatedBy(petrov());
        result.getAuthors().add(petrov());
        result.getAuthors().add(kuznetcov());
        result.getOptions().add(option("A", "17, 18, 71, 72", 1, ""));
        result.getOptions().add(option("B", "16, 19, 70, 72", 0, ""));
        result.getOptions().add(option("C", "0, 17, 18,55, 71, 72", 0, ""));
        result.getOptions().add(option("D", "0, 18, 71, 100", 0, ""));
        return result;
    }

    private Task task03() {
        final Task result = new Task();
        result.setQuestion("Что относится к нефункциональному тестированию?");
        result.setStatus(statusRepository.findById("APPROVED"));
        result.setComplexity(5);
        result.getCategories().addAll(categories("JAVA", "TEST"));
        result.setDifficulty(difficulty("MEDIUM"));
        result.setExpectation(expectation("SINGLESELECT"));
        result.setOwnership(ownership("PUBLIC"));
        result.setMindflow(mindflow("FOUNDATIONS"));
        result.setWorkflow(workflow("MACHINE"));
        result.setCreatedBy(petrov());
        result.getAuthors().add(petrov());
        result.getAuthors().add(kuznetcov());
        result.getOptions().add(option("A", "Модульное тестирование", 0, ""));
        result.getOptions().add(option("B", "Регрессионное тестирование", 0, ""));
        result.getOptions().add(option("C", "Тестирование производительности", 1, ""));
        return result;
    }

    private Task task04() {
        final Task result = new Task();
        result.setQuestion("Какова цель критерия выхода?");
        result.setStatus(statusRepository.findById("APPROVED"));
        result.setComplexity(5);
        result.getCategories().addAll(categories("JAVA", "TEST"));
        result.setDifficulty(difficulty("MEDIUM"));
        result.setExpectation(expectation("SINGLESELECT"));
        result.setOwnership(ownership("PUBLIC"));
        result.setMindflow(mindflow("FOUNDATIONS"));
        result.setWorkflow(workflow("MACHINE"));
        result.setCreatedBy(petrov());
        result.getAuthors().add(petrov());
        result.getAuthors().add(kuznetcov());
        result.getOptions().add(option("A", "Определить, когда нужно заканчивать тестирование", 0, ""));
        result.getOptions().add(option("B", "Определить окончание уровня тестирования", 0, ""));
        result.getOptions().add(option("C", "Определить, когда набор тестов достиг определенной цели", 0, ""));
        result.getOptions().add(option("D", "Все вышеперечисленное", 1, ""));
        return result;
    }

    private Task task05() {
        final Task result = new Task();
        result.setQuestion("Какой инструмент используется для тестирования веб-сервисов?");
        result.setStatus(statusRepository.findById("APPROVED"));
        result.setComplexity(5);
        result.getCategories().addAll(categories("JAVA", "TEST"));
        result.setDifficulty(difficulty("MEDIUM"));
        result.setExpectation(expectation("SINGLESELECT"));
        result.setOwnership(ownership("PUBLIC"));
        result.setMindflow(mindflow("FOUNDATIONS"));
        result.setWorkflow(workflow("MACHINE"));
        result.setCreatedBy(petrov());
        result.getAuthors().add(petrov());
        result.getAuthors().add(kuznetcov());
        result.getOptions().add(option("A", "Selenium IDE", 0, ""));
        result.getOptions().add(option("B", "JMeter", 0, ""));
        result.getOptions().add(option("C", "SOAP UI", 1, ""));
        result.getOptions().add(option("D", "Fiddler4", 0, ""));
        return result;
    }

    private Task task06() {
        final Task result = new Task();
        result.setQuestion("Что не относится к проектным рискам:");
        result.setStatus(statusRepository.findById("APPROVED"));
        result.setComplexity(5);
        result.getCategories().addAll(categories("JAVA", "TEST"));
        result.setDifficulty(difficulty("MEDIUM"));
        result.setExpectation(expectation("SINGLESELECT"));
        result.setOwnership(ownership("PUBLIC"));
        result.setMindflow(mindflow("FOUNDATIONS"));
        result.setWorkflow(workflow("MACHINE"));
        result.setCreatedBy(petrov());
        result.getAuthors().add(petrov());
        result.getAuthors().add(kuznetcov());
        result.getOptions().add(option("A", "Недостаток квалификации, подготовки и сотрудников", 0, ""));
        result.getOptions().add(option("B", "Вовремя не готово тестовое окружение", 0, ""));
        result.getOptions().add(option("C", "Плохие характеристики программного обеспечения", 1, ""));
        result.getOptions().add(option("D", "Проблемы в межличностном общении сотрудников", 0, ""));
        return result;
    }

    private Task task07() {
        final Task result = new Task();
        result.setQuestion("Каким образом могут быть определены классы эквивалентности:");
        result.setStatus(statusRepository.findById("APPROVED"));
        result.setComplexity(5);
        result.getCategories().addAll(categories("JAVA", "TEST"));
        result.setDifficulty(difficulty("MEDIUM"));
        result.setExpectation(expectation("SINGLESELECT"));
        result.setOwnership(ownership("PUBLIC"));
        result.setMindflow(mindflow("FOUNDATIONS"));
        result.setWorkflow(workflow("MACHINE"));
        result.setCreatedBy(petrov());
        result.getAuthors().add(petrov());
        result.getAuthors().add(kuznetcov());
        result.getOptions().add(option("A", "Только для валидных входных, выходных, внутренних  данных", 0, ""));
        result.getOptions().add(option("B", "Для валидных и невалидных входных, выходных, внутренних данных", 1, ""));
        result.getOptions().add(option("C", "Только для валидных и невалидных входных данных", 0, ""));
        result.getOptions().add(option("D", "Только для валидных входных данных", 0, ""));
        return result;
    }

    private Task task08() {
        final Task result = new Task();
        result.setQuestion("К итеративно-инкрементным моделям разработки программного обеспечения относится (относятся):");
        result.setStatus(statusRepository.findById("APPROVED"));
        result.setComplexity(5);
        result.getCategories().addAll(categories("JAVA", "TEST"));
        result.setDifficulty(difficulty("MEDIUM"));
        result.setExpectation(expectation("SINGLESELECT"));
        result.setOwnership(ownership("PUBLIC"));
        result.setMindflow(mindflow("FOUNDATIONS"));
        result.setWorkflow(workflow("MACHINE"));
        result.setCreatedBy(petrov());
        result.getAuthors().add(petrov());
        result.getAuthors().add(kuznetcov());
        result.getOptions().add(option("A", "Agile - методологии", 0, ""));
        result.getOptions().add(option("B", "Rational Unified Process", 0, ""));
        result.getOptions().add(option("C", "Прототипирование", 0, ""));
        result.getOptions().add(option("D", "Все вышеперечисленные", 1, ""));
        return result;
    }

    private Task task09() {
        final Task result = new Task();
        result.setQuestion("Какая из следующих активностей относится к этапу анализа и проектирования тестовых сценариев:");
        result.setStatus(statusRepository.findById("APPROVED"));
        result.setComplexity(5);
        result.getCategories().addAll(categories("JAVA", "TEST"));
        result.setDifficulty(difficulty("MEDIUM"));
        result.setExpectation(expectation("SINGLESELECT"));
        result.setOwnership(ownership("PUBLIC"));
        result.setMindflow(mindflow("FOUNDATIONS"));
        result.setWorkflow(workflow("MACHINE"));
        result.setCreatedBy(petrov());
        result.getAuthors().add(petrov());
        result.getAuthors().add(kuznetcov());
        result.getOptions().add(option("A", "Ревью тест-базиса", 1, ""));
        result.getOptions().add(option("B", "Определение основных целей, задач и рисков тестирования", 0, ""));
        result.getOptions().add(option("C", "Написание отчета о тестировании", 0, ""));
        result.getOptions().add(option("D", "Создание тестовых наборов и данных", 0, ""));
        return result;
    }

    private Task task10() {
        final Task result = new Task();
        result.setQuestion("Принцип тестирования 'парадокс пестицида' означает следующее:");
        result.setStatus(statusRepository.findById("APPROVED"));
        result.setComplexity(5);
        result.getCategories().addAll(categories("JAVA", "TEST"));
        result.setDifficulty(difficulty("MEDIUM"));
        result.setExpectation(expectation("SINGLESELECT"));
        result.setOwnership(ownership("PUBLIC"));
        result.setMindflow(mindflow("FOUNDATIONS"));
        result.setWorkflow(workflow("MACHINE"));
        result.setCreatedBy(petrov());
        result.getAuthors().add(petrov());
        result.getAuthors().add(kuznetcov());
        result.getOptions().add(option("A", "В зависимости от вида тестирования необходим разный набор тестов", 0, ""));
        result.getOptions().add(option("B", "Как правило, большая часть обнаруженных дефектов содержится в небольшом количестве модулей системы", 0, ""));
        result.getOptions().add(option("C", "Тестовые активности должны быть начаты как можно раньше", 0, ""));
        result.getOptions().add(option("D", "Один и тот же набор тестовых сценариев в конечном счете больше не будет находить новые дефекты", 1, ""));
        return result;
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

    private TaskMindflow mindflow(final String id) {
        return mindflowRepository.findById(id);
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
