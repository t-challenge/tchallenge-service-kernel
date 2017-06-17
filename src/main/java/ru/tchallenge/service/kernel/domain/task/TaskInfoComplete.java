package ru.tchallenge.service.kernel.domain.task;

import java.util.Collection;

import ru.tchallenge.service.kernel.domain.task.input.TaskInputInfoComplete;
import ru.tchallenge.service.kernel.domain.task.option.TaskOptionInfoComplete;

public final class TaskInfoComplete extends TaskInfo {

    private Long id;
    private String status;
    private String createdBy;

    private Collection<String> categories;
    private Integer complexity;
    private String difficulty;
    private Collection<String> families;
    private String mindflow;
    private String workflow;

    private TaskInputInfoComplete input;
    private Collection<TaskOptionInfoComplete> options;

    private Collection<String> tags;

    private String ownership;
    private Collection<String> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    public void setCategories(Collection<String> categories) {
        this.categories = categories;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Collection<String> getFamilies() {
        return families;
    }

    public void setFamilies(Collection<String> families) {
        this.families = families;
    }

    public String getMindflow() {
        return mindflow;
    }

    public void setMindflow(String mindflow) {
        this.mindflow = mindflow;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    public TaskInputInfoComplete getInput() {
        return input;
    }

    public void setInput(TaskInputInfoComplete input) {
        this.input = input;
    }

    public Collection<TaskOptionInfoComplete> getOptions() {
        return options;
    }

    public void setOptions(Collection<TaskOptionInfoComplete> options) {
        this.options = options;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public void setTags(Collection<String> tags) {
        this.tags = tags;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public Collection<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<String> authors) {
        this.authors = authors;
    }
}
