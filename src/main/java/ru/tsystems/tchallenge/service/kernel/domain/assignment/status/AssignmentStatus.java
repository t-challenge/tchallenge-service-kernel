package ru.tsystems.tchallenge.service.kernel.domain.assignment.status;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class AssignmentStatus extends EnumeratedEntity {

    public AssignmentStatus(final String id) {
        super(id);
    }

    @JpaConstructor
    protected AssignmentStatus() {

    }
}
