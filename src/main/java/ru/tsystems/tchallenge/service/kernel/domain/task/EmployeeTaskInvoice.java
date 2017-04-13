package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.task.input.EmployeeTaskInputInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.task.option.EmployeeTaskOptionInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public abstract class EmployeeTaskInvoice extends GenericInvoice {

    private String title;
    private String introduction;
    private String question;
    private String expectation;
    private Integer complexity;
    private Collection<String> categories;
    private String difficulty;
    private String ownership;
    private String workflow;
    private EmployeeTaskInputInvoice input;
    private Collection<EmployeeTaskOptionInvoice> options;
    private Collection<String> authors;

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

    public String getExpectation() {
        return expectation;
    }

    public void setExpectation(String expectation) {
        this.expectation = expectation;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    public void setCategories(Collection<String> categories) {
        this.categories = categories;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    public EmployeeTaskInputInvoice getInput() {
        return input;
    }

    public void setInput(EmployeeTaskInputInvoice input) {
        this.input = input;
    }

    public Collection<EmployeeTaskOptionInvoice> getOptions() {
        return options;
    }

    public void setOptions(Collection<EmployeeTaskOptionInvoice> options) {
        this.options = options;
    }

    public Collection<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<String> authors) {
        this.authors = authors;
    }
}
