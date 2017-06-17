package ru.tchallenge.service.kernel.domain.task.snippet;

import ru.tchallenge.service.kernel.generic.GenericInvoice;

public final class TaskSnippetInvoice extends GenericInvoice {

    private String content;
    private Integer stance;
    private String style;

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Integer getStance() {
        return stance;
    }

    public void setStance(final Integer stance) {
        this.stance = stance;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(final String style) {
        this.style = style;
    }
}
