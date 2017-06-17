package ru.tchallenge.service.kernel.domain.task.input;

import ru.tchallenge.service.kernel.generic.GenericInvoice;

public final class TaskInputInvoice extends GenericInvoice {

    private String content;
    private String explanation;

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(final String explanation) {
        this.explanation = explanation;
    }
}
