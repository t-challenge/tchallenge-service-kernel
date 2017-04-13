package ru.tsystems.tchallenge.service.kernel.domain.task.option;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class EmployeeTaskOptionInvoice extends GenericInvoice {

    private String content;
    private Boolean correct;
    private String explanation;
    private String textcode;

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(final Boolean correct) {
        this.correct = correct;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(final String explanation) {
        this.explanation = explanation;
    }

    public String getTextcode() {
        return textcode;
    }

    public void setTextcode(final String textcode) {
        this.textcode = textcode;
    }
}
