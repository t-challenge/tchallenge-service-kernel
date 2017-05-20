package ru.tsystems.tchallenge.service.kernel.domain.task.tags;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class TaskTag extends EnumeratedEntity {

    public TaskTag(final String id) {
        super(id);
    }

    @JpaConstructor
    protected TaskTag() {

    }
}
