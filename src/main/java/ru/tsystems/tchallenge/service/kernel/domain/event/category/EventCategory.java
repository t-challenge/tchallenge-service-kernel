package ru.tsystems.tchallenge.service.kernel.domain.event.category;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class EventCategory extends EnumeratedEntity {

    public EventCategory(final String id) {
        super(id);
    }

    @JpaConstructor
    protected EventCategory() {

    }
}
