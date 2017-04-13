package ru.tsystems.tchallenge.service.kernel.domain.task.image.format;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class TaskImageFormat extends EnumeratedEntity {

    public TaskImageFormat(final String id) {
        super(id);
    }

    @JpaConstructor
    protected TaskImageFormat() {

    }
}
