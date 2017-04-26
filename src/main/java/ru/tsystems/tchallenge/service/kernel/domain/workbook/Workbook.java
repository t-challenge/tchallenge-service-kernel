package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ru.tsystems.tchallenge.service.kernel.domain.assignment.Assignment;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.Candidate;
import ru.tsystems.tchallenge.service.kernel.domain.event.Event;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.Maturity;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.Specialization;
import ru.tsystems.tchallenge.service.kernel.domain.workbook.status.WorkbookStatus;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Workbook extends SequentialEntity {

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Assignment> assignments = new ArrayList<>();

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Maturity maturity;

    @ManyToOne
    private Specialization specialization;

    @ManyToOne
    private WorkbookStatus status;

    @Column
    private Integer score;

    @Column
    private Integer maxScore;

    public Collection<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Collection<Assignment> assignments) {
        this.assignments = assignments;
    }

    public WorkbookStatus getStatus() {
        return status;
    }

    public void setStatus(WorkbookStatus status) {
        this.status = status;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Maturity getMaturity() {
        return maturity;
    }

    public void setMaturity(Maturity maturity) {
        this.maturity = maturity;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
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
