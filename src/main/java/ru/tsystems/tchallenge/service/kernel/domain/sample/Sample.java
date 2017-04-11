package ru.tsystems.tchallenge.service.kernel.domain.sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import ru.tsystems.tchallenge.service.kernel.domain.sample.status.SampleStatus;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Sample extends SequentialEntity {

    @Column
    private String title;

    @Column
    private String employeeOnlyText;

    @ManyToOne
    private SampleStatus status;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getEmployeeOnlyText() {
        return employeeOnlyText;
    }

    public void setEmployeeOnlyText(final String employeeOnlyText) {
        this.employeeOnlyText = employeeOnlyText;
    }

    public SampleStatus getStatus() {
        return status;
    }

    public void setStatus(final SampleStatus status) {
        this.status = status;
    }
}
