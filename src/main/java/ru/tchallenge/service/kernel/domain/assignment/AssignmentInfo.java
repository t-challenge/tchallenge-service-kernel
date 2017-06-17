package ru.tchallenge.service.kernel.domain.assignment;

import ru.tchallenge.service.kernel.domain.task.TaskInfoRestricted;
import ru.tchallenge.service.kernel.generic.GenericInfo;

public final class AssignmentInfo extends GenericInfo {

    private String id;
    private Integer stance;
    private TaskInfoRestricted task;
    private Integer score;
    private Integer maxScore;
    private String input;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStance() {
        return stance;
    }

    public void setStance(Integer stance) {
        this.stance = stance;
    }

    public TaskInfoRestricted getTask() {
        return task;
    }

    public void setTask(TaskInfoRestricted task) {
        this.task = task;
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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
