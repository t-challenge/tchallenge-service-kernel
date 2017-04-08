package ru.tsystems.tchallenge.service.kernel.domain.solution.input;

import javax.persistence.Column;
import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.generic.entity.CasualEntity;

@Entity
public class SolutionInput extends CasualEntity {

    @Column
    private String content;

    @Column
    private String explanation;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
