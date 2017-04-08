package ru.tsystems.tchallenge.service.kernel.domain.task.status;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class TaskStatus extends EnumeratedEntity {

    public TaskStatus(final String id) {
        super(id);
    }

    @JpaConstructor
    protected TaskStatus() {

    }
}
