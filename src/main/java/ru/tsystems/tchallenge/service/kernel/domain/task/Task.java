package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ru.tsystems.tchallenge.service.kernel.domain.employee.Employee;
import ru.tsystems.tchallenge.service.kernel.domain.solution.input.SolutionInput;
import ru.tsystems.tchallenge.service.kernel.domain.solution.option.SolutionOption;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategory;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficulty;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectation;
import ru.tsystems.tchallenge.service.kernel.domain.task.status.TaskStatus;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Task extends SequentialEntity {

    @Column
    private String title;

    @Column
    private String introduction;

    @Column
    private String question;

    @ManyToOne
    private TaskStatus status;

    @Column
    private Integer complexity;

    @ManyToMany
    private Collection<TaskCategory> categories = new ArrayList<>();

    @ManyToOne
    private TaskDifficulty difficulty;

    @ManyToOne
    private TaskExpectation expectation;

    @OneToOne(cascade = CascadeType.ALL)
    private SolutionInput solutionInput;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<SolutionOption> solutionOptions = new ArrayList<>();

    @ManyToMany
    private Collection<Employee> authors = new ArrayList<>();

    @ManyToOne
    private Employee createdBy;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(final String introduction) {
        this.introduction = introduction;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public Collection<TaskCategory> getCategories() {
        return categories;
    }

    public void setCategories(Collection<TaskCategory> categories) {
        this.categories = categories;
    }

    public TaskDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(TaskDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public TaskExpectation getExpectation() {
        return expectation;
    }

    public void setExpectation(TaskExpectation expectation) {
        this.expectation = expectation;
    }

    public SolutionInput getSolutionInput() {
        return solutionInput;
    }

    public void setSolutionInput(SolutionInput solutionInput) {
        this.solutionInput = solutionInput;
    }

    public Collection<SolutionOption> getSolutionOptions() {
        return solutionOptions;
    }

    public void setSolutionOptions(Collection<SolutionOption> solutionOptions) {
        this.solutionOptions = solutionOptions;
    }

    public Collection<Employee> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<Employee> authors) {
        this.authors = authors;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }
}
