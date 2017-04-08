package ru.tsystems.tchallenge.service.kernel.domain.solution.input;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class SolutionInputInvoice extends GenericInvoice {

    private String content;
    private String explanation;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
