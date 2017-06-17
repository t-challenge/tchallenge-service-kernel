package ru.tchallenge.service.kernel.domain.assignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import ru.tchallenge.service.kernel.domain.assignment.status.AssignmentStatus;
import ru.tchallenge.service.kernel.domain.task.Task;
import ru.tchallenge.service.kernel.domain.workbook.Workbook;
import ru.tchallenge.service.kernel.generic.entity.CasualEntity;

@Entity
public class Assignment extends CasualEntity {

    @Column
    private String input;

    @Column
    private Integer stance;

    @ManyToOne
    private Task task;

    @ManyToOne
    private Workbook workbook;

    @ManyToOne
    private AssignmentStatus status;

    @Column
    private Integer score;

    @Column
    private Integer maxScore;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer getStance() {
        return stance;
    }

    public void setStance(Integer stance) {
        this.stance = stance;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }
}
