package ru.tchallenge.service.kernel.domain.task.input;

import javax.persistence.Column;
import javax.persistence.Entity;

import ru.tchallenge.service.kernel.generic.entity.CasualEntity;

@Entity
public class TaskInput extends CasualEntity {

    @Column
    private String content;

    @Column
    private String explanation;

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(final String explanation) {
        this.explanation = explanation;
    }
}
