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
import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImage;
import ru.tsystems.tchallenge.service.kernel.domain.task.input.TaskInput;
import ru.tsystems.tchallenge.service.kernel.domain.task.option.TaskOption;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategory;
import ru.tsystems.tchallenge.service.kernel.domain.task.difficulty.TaskDifficulty;
import ru.tsystems.tchallenge.service.kernel.domain.task.expectation.TaskExpectation;
import ru.tsystems.tchallenge.service.kernel.domain.task.ownership.TaskOwnership;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippet;
import ru.tsystems.tchallenge.service.kernel.domain.task.status.TaskStatus;
import ru.tsystems.tchallenge.service.kernel.domain.task.workflow.TaskWorkflow;
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

    @ManyToOne
    private TaskOwnership ownership;

    @ManyToOne
    private TaskWorkflow workflow;

    @OneToOne(cascade = CascadeType.ALL)
    private TaskInput input;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<TaskOption> options = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<TaskImage> images = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<TaskSnippet> snippets = new ArrayList<>();

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

    public void setStatus(final TaskStatus status) {
        this.status = status;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(final Integer complexity) {
        this.complexity = complexity;
    }

    public Collection<TaskCategory> getCategories() {
        return categories;
    }

    public TaskDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(final TaskDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public TaskExpectation getExpectation() {
        return expectation;
    }

    public void setExpectation(final TaskExpectation expectation) {
        this.expectation = expectation;
    }

    public TaskOwnership getOwnership() {
        return ownership;
    }

    public void setOwnership(final TaskOwnership ownership) {
        this.ownership = ownership;
    }

    public TaskWorkflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(final TaskWorkflow workflow) {
        this.workflow = workflow;
    }

    public TaskInput getInput() {
        return input;
    }

    public void setInput(final TaskInput input) {
        this.input = input;
    }

    public Collection<TaskOption> getOptions() {
        return options;
    }

    public Collection<TaskImage> getImages() {
        return images;
    }

    public Collection<TaskSnippet> getSnippets() {
        return snippets;
    }

    public Collection<Employee> getAuthors() {
        return authors;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final Employee createdBy) {
        this.createdBy = createdBy;
    }
}
