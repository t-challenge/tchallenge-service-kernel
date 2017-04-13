package ru.tsystems.tchallenge.service.kernel.domain.task.image;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class TaskImageInfo extends GenericInfo {

    private final String content;
    private final String description;
    private final String format;
    private final Integer height;
    private final Integer width;
    private final Integer stance;

    public TaskImageInfo(final String content,
                         final String description,
                         final String format,
                         final Integer height,
                         final Integer width,
                         final Integer stance) {
        this.content = content;
        this.description = description;
        this.format = format;
        this.height = height;
        this.width = width;
        this.stance = stance;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return format;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getStance() {
        return stance;
    }
}
