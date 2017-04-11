package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ru.tsystems.tchallenge.service.kernel.domain.assignment.Assignment;
import ru.tsystems.tchallenge.service.kernel.domain.workbook.status.WorkbookStatus;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Workbook extends SequentialEntity {

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Assignment> assignments = new ArrayList<>();

    @ManyToOne
    private WorkbookStatus status;

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
}
