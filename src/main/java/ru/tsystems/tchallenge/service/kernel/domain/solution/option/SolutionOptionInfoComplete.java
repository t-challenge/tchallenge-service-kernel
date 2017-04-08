package ru.tsystems.tchallenge.service.kernel.domain.solution.option;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class SolutionOptionInfoComplete extends GenericInfo {

    private String content;
    private Boolean correct;
    private String explanation;
    private String textcode;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
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
