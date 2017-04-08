package ru.tsystems.tchallenge.service.kernel.domain.task.expectation;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class TaskExpectation extends EnumeratedEntity {

    public TaskExpectation(final String id) {
        super(id);
    }

    @JpaConstructor
    protected TaskExpectation() {

    }
}
