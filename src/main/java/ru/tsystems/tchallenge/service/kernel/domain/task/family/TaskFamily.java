package ru.tsystems.tchallenge.service.kernel.domain.task.family;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class TaskFamily extends EnumeratedEntity {

    public TaskFamily(final String id) {
        super(id);
    }

    @JpaConstructor
    protected TaskFamily() {

    }
}
