package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImageInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.input.EmployeeTaskInputInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.option.EmployeeTaskOptionInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippetInfo;

public final class EmployeeTaskInfo extends TaskInfo {

    private final Long id;
    private final String status;
    private final Integer complexity;
    private final Collection<String> categories;
    private final String difficulty;
    private final String ownership;
    private final String workflow;
    private final EmployeeTaskInputInfo input;
    private final Collection<EmployeeTaskOptionInfo> options;
    private final Collection<String> authors;
    private final String mindflow;
    private final String createdBy;
    private final Instant createdAt;
    private final Instant modifiedAt;

    public EmployeeTaskInfo(final Long id,
                            final String title,
                            final String introduction,
                            final String question,
                            final String expectation,
                            final Collection<TaskImageInfo> images,
                            final Collection<TaskSnippetInfo> snippets,
                            final String status,
                            final Integer complexity,
                            final Collection<String> categories,
                            final String difficulty,
                            final String ownership,
                            final String workflow,
                            final EmployeeTaskInputInfo input,
                            final Collection<EmployeeTaskOptionInfo> options,
                            final Collection<String> authors,
                            final String mindflow,
                            final String createdBy,
                            final Instant createdAt,
                            final Instant modifiedAt) {
        super(title, introduction, question, expectation, images, snippets);
        this.id = id;
        this.status = status;
        this.complexity = complexity;
        this.categories = new ArrayList<>(categories);
        this.difficulty = difficulty;
        this.ownership = ownership;
        this.workflow = workflow;
        this.input = input;
        this.options = new ArrayList<>(options);
        this.authors = new ArrayList<>(authors);
        this.mindflow = mindflow;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public Collection<String> getCategories() {
        return new ArrayList<>(categories);
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getOwnership() {
        return ownership;
    }

    public String getWorkflow() {
        return workflow;
    }

    public EmployeeTaskInputInfo getInput() {
        return input;
    }

    public Collection<EmployeeTaskOptionInfo> getOptions() {
        return new ArrayList<>(options);
    }

    public Collection<String> getAuthors() {
        return new ArrayList<>(authors);
    }

    public String getMindflow() {
        return mindflow;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }
}
