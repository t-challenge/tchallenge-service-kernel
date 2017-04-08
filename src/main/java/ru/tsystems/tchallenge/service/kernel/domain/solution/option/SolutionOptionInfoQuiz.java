package ru.tsystems.tchallenge.service.kernel.domain.solution.option;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class SolutionOptionInfoQuiz extends GenericInfo {

    private String content;
    private String textcode;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTextcode() {
        return textcode;
    }

    public void setTextcode(String textcode) {
        this.textcode = textcode;
    }
}
