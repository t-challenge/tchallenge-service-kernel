package ru.tsystems.tchallenge.service.kernel.domain.task.option;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class TaskOptionInfoRestricted extends GenericInfo {

    private final String content;
    private final String textcode;

    public TaskOptionInfoRestricted(final String content,
                                    final String textcode) {
        this.content = content;
        this.textcode = textcode;
    }

    public String getContent() {
        return content;
    }

    public String getTextcode() {
        return textcode;
    }
}
