package ru.tchallenge.service.kernel.domain.task.snippet;

import ru.tchallenge.service.kernel.generic.GenericInfo;

public final class TaskSnippetInfo extends GenericInfo {

    private final String content;
    private final Integer stance;
    private final String style;

    public TaskSnippetInfo(final String content,
                           final Integer stance,
                           final String style) {
        this.content = content;
        this.stance = stance;
        this.style = style;
    }

    public String getContent() {
        return content;
    }

    public Integer getStance() {
        return stance;
    }

    public String getStyle() {
        return style;
    }
}
