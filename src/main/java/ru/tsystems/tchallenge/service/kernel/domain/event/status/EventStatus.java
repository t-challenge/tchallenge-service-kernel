package ru.tsystems.tchallenge.service.kernel.domain.event.status;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class EventStatus extends EnumeratedEntity {

    public EventStatus(final String id) {
        super(id);
    }

    @JpaConstructor
    protected EventStatus() {

    }
}
