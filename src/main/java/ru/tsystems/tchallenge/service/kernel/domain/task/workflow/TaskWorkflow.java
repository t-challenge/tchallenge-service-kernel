package ru.tsystems.tchallenge.service.kernel.domain.task.workflow;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class TaskWorkflow extends EnumeratedEntity {

    public TaskWorkflow(final String id) {
        super(id);
    }

    @JpaConstructor
    protected TaskWorkflow() {

    }
}
