package ru.tchallenge.service.kernel.domain.workbook;

import java.util.Collection;

import ru.tchallenge.service.kernel.domain.assignment.AssignmentInfo;
import ru.tchallenge.service.kernel.generic.GenericInfo;

public final class WorkbookInfo extends GenericInfo {

    private Long id;
    private String status;
    private String event;
    private Collection<AssignmentInfo> assignments;
    private Integer score;
    private Integer maxScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Collection<AssignmentInfo> getAssignments() {
        return assignments;
    }

    public void setAssignments(Collection<AssignmentInfo> assignments) {
        this.assignments = assignments;
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
