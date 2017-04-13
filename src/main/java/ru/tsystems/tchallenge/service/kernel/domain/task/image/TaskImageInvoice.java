package ru.tsystems.tchallenge.service.kernel.domain.task.image;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class TaskImageInvoice extends GenericInvoice {

    private String content;
    private String description;
    private String format;
    private Integer height;
    private Integer width;
    private Integer stance;

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(final String format) {
        this.format = format;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(final Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(final Integer width) {
        this.width = width;
    }

    public Integer getStance() {
        return stance;
    }

    public void setStance(final Integer stance) {
        this.stance = stance;
    }
}
