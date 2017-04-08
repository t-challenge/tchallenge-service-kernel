package ru.tsystems.tchallenge.service.kernel.domain.solution.option;

import javax.persistence.Column;
import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.generic.entity.CasualEntity;

@Entity
public class SolutionOption extends CasualEntity {

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

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTextcode() {
        return textcode;
    }

    public void setTextcode(String textcode) {
        this.textcode = textcode;
    }
}
