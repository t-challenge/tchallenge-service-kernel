package ru.tsystems.tchallenge.service.kernel.domain.task.snippet.style;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class TaskSnippetStyle extends EnumeratedEntity {

    public TaskSnippetStyle(final String id) {
        super(id);
    }

    @JpaConstructor
    protected TaskSnippetStyle() {

    }
}
