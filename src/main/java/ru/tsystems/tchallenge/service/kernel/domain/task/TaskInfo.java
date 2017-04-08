package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.time.Instant;
import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.employee.EmployeeInfoShort;
import ru.tsystems.tchallenge.service.kernel.domain.solution.input.SolutionInputInfo;
import ru.tsystems.tchallenge.service.kernel.domain.solution.option.SolutionOptionInfoComplete;
import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class TaskInfo extends GenericInfo {

    private Long id;
    private String title;
    private String introduction;
    private String question;
    private String status;
    private String difficulty;
    private String expectation;
    private Collection<String> categories;
    private SolutionInputInfo solutionInput;
    private Collection<SolutionOptionInfoComplete> solutionOptions;
    private Collection<EmployeeInfoShort> authors;
    private EmployeeInfoShort createdBy;
    private Instant createdAt;
    private Instant modifiedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getExpectation() {
        return expectation;
    }

    public void setExpectation(String expectation) {
        this.expectation = expectation;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    public void setCategories(Collection<String> categories) {
        this.categories = categories;
    }

    public SolutionInputInfo getSolutionInput() {
        return solutionInput;
    }

    public void setSolutionInput(SolutionInputInfo solutionInput) {
        this.solutionInput = solutionInput;
    }

    public Collection<SolutionOptionInfoComplete> getSolutionOptions() {
        return solutionOptions;
    }

    public void setSolutionOptions(Collection<SolutionOptionInfoComplete> solutionOptions) {
        this.solutionOptions = solutionOptions;
    }

    public Collection<EmployeeInfoShort> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<EmployeeInfoShort> authors) {
        this.authors = authors;
    }

    public EmployeeInfoShort getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(EmployeeInfoShort createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(final Instant modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

}
