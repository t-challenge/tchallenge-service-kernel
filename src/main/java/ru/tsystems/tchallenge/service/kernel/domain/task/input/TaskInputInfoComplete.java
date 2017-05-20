package ru.tsystems.tchallenge.service.kernel.domain.task.input;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class TaskInputInfoComplete extends GenericInfo {

    private final String content;
    private final String explanation;

    public TaskInputInfoComplete(final String content,
                                 final String explanation) {
        this.content = content;
        this.explanation = explanation;
    }

    public String getContent() {
        return content;
    }

    public String getExplanation() {
        return explanation;
    }
}
