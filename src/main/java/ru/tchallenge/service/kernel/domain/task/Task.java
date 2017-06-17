package ru.tchallenge.service.kernel.domain.task;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ru.tchallenge.service.kernel.domain.employee.Employee;
import ru.tchallenge.service.kernel.domain.task.family.TaskFamily;
import ru.tchallenge.service.kernel.domain.task.image.TaskImage;
import ru.tchallenge.service.kernel.domain.task.input.TaskInput;
import ru.tchallenge.service.kernel.domain.task.mindflow.TaskMindflow;
import ru.tchallenge.service.kernel.domain.task.option.TaskOption;
import ru.tchallenge.service.kernel.domain.task.category.TaskCategory;
import ru.tchallenge.service.kernel.domain.task.difficulty.TaskDifficulty;
import ru.tchallenge.service.kernel.domain.task.expectation.TaskExpectation;
import ru.tchallenge.service.kernel.domain.task.ownership.TaskOwnership;
import ru.tchallenge.service.kernel.domain.task.snippet.TaskSnippet;
import ru.tchallenge.service.kernel.domain.task.status.TaskStatus;
import ru.tchallenge.service.kernel.domain.task.tags.TaskTag;
import ru.tchallenge.service.kernel.domain.task.workflow.TaskWorkflow;
import ru.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Task extends SequentialEntity {

    @ManyToOne
    private TaskStatus status;

    @ManyToOne
    private Employee createdBy;

    @Column
    private String introduction;

    @Column
    private String question;

    @ManyToMany
    private Collection<TaskCategory> categories = new ArrayList<>();

    @Column
    private Integer complexity;

    @ManyToOne
    private TaskDifficulty difficulty;

    @ManyToMany
    private Collection<TaskFamily> families = new ArrayList<>();

    @ManyToOne
    private TaskMindflow mindflow;

    @ManyToOne
    private TaskWorkflow workflow;

    @ManyToOne
    private TaskExpectation expectation;

    @OneToOne(cascade = CascadeType.ALL)
    private TaskInput input;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<TaskOption> options = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<TaskImage> images = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<TaskSnippet> snippets = new ArrayList<>();

    @ManyToMany
    private Collection<TaskTag> tags = new ArrayList<>();

    @ManyToOne
    private TaskOwnership ownership;

    @ManyToMany
    private Collection<Employee> authors = new ArrayList<>();

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Collection<TaskCategory> getCategories() {
        return categories;
    }

    public void setCategories(Collection<TaskCategory> categories) {
        this.categories = categories;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public TaskDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(TaskDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Collection<TaskFamily> getFamilies() {
        return families;
    }

    public void setFamilies(Collection<TaskFamily> families) {
        this.families = families;
    }

    public TaskMindflow getMindflow() {
        return mindflow;
    }

    public void setMindflow(TaskMindflow mindflow) {
        this.mindflow = mindflow;
    }

    public TaskWorkflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(TaskWorkflow workflow) {
        this.workflow = workflow;
    }

    public TaskExpectation getExpectation() {
        return expectation;
    }

    public void setExpectation(TaskExpectation expectation) {
        this.expectation = expectation;
    }

    public TaskInput getInput() {
        return input;
    }

    public void setInput(TaskInput input) {
        this.input = input;
    }

    public Collection<TaskOption> getOptions() {
        return options;
    }

    public void setOptions(Collection<TaskOption> options) {
        this.options = options;
    }

    public Collection<TaskImage> getImages() {
        return images;
    }

    public void setImages(Collection<TaskImage> images) {
        this.images = images;
    }

    public Collection<TaskSnippet> getSnippets() {
        return snippets;
    }

    public void setSnippets(Collection<TaskSnippet> snippets) {
        this.snippets = snippets;
    }

    public Collection<TaskTag> getTags() {
        return tags;
    }

    public void setTags(Collection<TaskTag> tags) {
        this.tags = tags;
    }

    public TaskOwnership getOwnership() {
        return ownership;
    }

    public void setOwnership(TaskOwnership ownership) {
        this.ownership = ownership;
    }

    public Collection<Employee> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<Employee> authors) {
        this.authors = authors;
    }
}
