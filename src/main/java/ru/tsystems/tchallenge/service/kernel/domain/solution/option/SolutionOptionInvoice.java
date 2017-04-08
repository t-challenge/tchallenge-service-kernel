package ru.tsystems.tchallenge.service.kernel.domain.solution.option;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class SolutionOptionInvoice extends GenericInvoice {

    private String content;
    private Integer correct;
    private String explanation;
    private String textcode;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTextcode() {
        return textcode;
    }

    public void setTextcode(String textcode) {
        this.textcode = textcode;
    }
}
