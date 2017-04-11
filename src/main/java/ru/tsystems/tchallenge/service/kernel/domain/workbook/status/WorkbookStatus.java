package ru.tsystems.tchallenge.service.kernel.domain.workbook.status;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class WorkbookStatus extends EnumeratedEntity {

    public WorkbookStatus(final String id) {
        super(id);
    }

    @JpaConstructor
    protected WorkbookStatus() {

    }
}
