package ru.tsystems.tchallenge.service.kernel.domain.task.snippet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyle;
import ru.tsystems.tchallenge.service.kernel.generic.entity.CasualEntity;

@Entity
public class TaskSnippet extends CasualEntity {

    @Column
    private String content;

    @Column
    private Integer stance;

    @ManyToOne
    private TaskSnippetStyle style;

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

    public TaskSnippetStyle getStyle() {
        return style;
    }

    public void setStyle(final TaskSnippetStyle style) {
        this.style = style;
    }
}
