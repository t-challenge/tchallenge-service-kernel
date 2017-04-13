package ru.tsystems.tchallenge.service.kernel.domain.task.image;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ru.tsystems.tchallenge.service.kernel.domain.task.image.content.TaskImageContent;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.format.TaskImageFormat;
import ru.tsystems.tchallenge.service.kernel.generic.entity.CasualEntity;

@Entity
public class TaskImage extends CasualEntity {

    @Column
    private String content;

    @Column
    private String description;

    @ManyToOne
    private TaskImageFormat format;

    @Column
    private Integer height;

    @Column
    private Integer width;

    @Column
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

    public TaskImageFormat getFormat() {
        return format;
    }

    public void setFormat(final TaskImageFormat format) {
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
