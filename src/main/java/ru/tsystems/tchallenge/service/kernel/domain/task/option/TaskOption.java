package ru.tsystems.tchallenge.service.kernel.domain.task.option;

import javax.persistence.Column;
import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.generic.entity.CasualEntity;

@Entity
public class TaskOption extends CasualEntity {

    @Column
    private String content;

    @Column
    private Integer correct;

    @Column
    private String explanation;

    @Column
    private String textcode;

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(final Integer correct) {
        this.correct = correct;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(final String explanation) {
        this.explanation = explanation;
    }

    public String getTextcode() {
        return textcode;
    }

    public void setTextcode(final String textcode) {
        this.textcode = textcode;
    }
}
