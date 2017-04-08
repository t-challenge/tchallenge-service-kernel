package ru.tsystems.tchallenge.service.kernel.domain.task;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class TaskUpdateInvoice extends GenericInvoice {

    private Long id;
    private String title;
    private String introduction;
    private String question;

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
}
