package ru.tsystems.tchallenge.service.kernel.domain.solution.input;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class SolutionInputInfo extends GenericInfo {

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
