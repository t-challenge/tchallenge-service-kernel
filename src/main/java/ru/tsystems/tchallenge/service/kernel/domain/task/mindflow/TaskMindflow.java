package ru.tsystems.tchallenge.service.kernel.domain.task.mindflow;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class TaskMindflow extends EnumeratedEntity {

    public TaskMindflow(final String id) {
        super(id);
    }

    @JpaConstructor
    protected TaskMindflow() {

    }
}
