package ru.tsystems.tchallenge.service.kernel.domain.task.option;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class TaskOptionInfoComplete extends GenericInfo {

    private final String content;
    private final Boolean correct;
    private final String explanation;
    private final String textcode;

    public TaskOptionInfoComplete(final String content,
                                  final Boolean correct,
                                  final String explanation,
                                  final String textcode) {
        this.content = content;
        this.correct = correct;
        this.explanation = explanation;
        this.textcode = textcode;
    }

    public String getContent() {
        return content;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getTextcode() {
        return textcode;
    }
}
