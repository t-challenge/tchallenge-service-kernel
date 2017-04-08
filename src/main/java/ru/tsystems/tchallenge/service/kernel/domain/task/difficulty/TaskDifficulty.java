package ru.tsystems.tchallenge.service.kernel.domain.task.difficulty;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class TaskDifficulty extends EnumeratedEntity {

    public TaskDifficulty(final String id) {
        super(id);
    }

    @JpaConstructor
    protected TaskDifficulty() {

    }
}
