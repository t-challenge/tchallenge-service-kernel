package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.domain.employee.Employee;
import ru.tsystems.tchallenge.service.kernel.domain.employee.EmployeeBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.employee.EmployeeRepository;
import ru.tsystems.tchallenge.service.kernel.domain.solution.input.SolutionInput;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategory;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategoryBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategoryRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficulty;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectation;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectationBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectationRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.status.TaskStatusBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.task.status.TaskStatusRepository;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.OrdinalEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskBootstrap extends OrdinalEntityBootstrap<Task> {

    @Autowired
    private EmployeeBootstrap employeeBootstrap;

    @Autowired
    private TaskCategoryBootstrap taskCategoryBootstrap;

    @Autowired
    private TaskExpectationBootstrap taskExpectationBootstrap;

    @Autowired
    private TaskDifficultyBootstrap difficultyBootstrap;

    @Autowired
    private TaskStatusBootstrap taskStatusBootstrap;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    @Autowired
    private TaskDifficultyRepository taskDifficultyRepository;

    @Autowired
    private TaskExpectationRepository taskExpectationRepository;

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Override
    protected void collectEntities(final Collection<Task> entities) {
        entities.add(seattleTask());
    }

    @Override
    protected GenericEntityRepository<Task, Long> getRepository() {
        return taskRepository;
    }

    private Task seattleTask() {
        final Task task = new Task();
        task.setTitle("Работа В Сиэттле.");
        task.setQuestion("Сколько нужно человек, чтобы вымыть все окна в Сиэттле?");
        task.setStatus(taskStatusRepository.findById("CREATED"));
        task.setComplexity(5);
        task.setCategories(categories("COMMON"));
        task.setDifficulty(difficulty("EASY"));
        task.setExpectation(expectation("SMALLINPUT"));
        task.setCreatedBy(petrov());
        task.getAuthors().add(petrov());
        task.getAuthors().add(kuznetcov());
        final SolutionInput input = new SolutionInput();
        input.setContent("4");
        input.setExplanation("Просто так");
        task.setSolutionInput(input);
        return task;
    }

    private Employee petrov() {
        return employee("ivan.petrov@some-email.com");
    }

    private Employee kuznetcov() {
        return employee("sergei.kuznetcov@some-email.com");
    }

    private Employee employee(final String login) {
        return employeeRepository.findByLogin(login);
    }

    private Collection<TaskCategory> categories(final String... ids) {
        return taskCategoryRepository.findAllById(Arrays.asList(ids));
    }

    private TaskDifficulty difficulty(final String id) {
        return taskDifficultyRepository.findById(id);
    }

    private TaskExpectation expectation(final String id) {
        return taskExpectationRepository.findById(id);
    }
}
