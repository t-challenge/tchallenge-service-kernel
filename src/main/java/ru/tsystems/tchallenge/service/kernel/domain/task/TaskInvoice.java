package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class TaskInvoice extends GenericInvoice {

    private String title;
    private String introduction;
    private String question;
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

    public Collection<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<String> authors) {
        this.authors = authors;
    }
}
