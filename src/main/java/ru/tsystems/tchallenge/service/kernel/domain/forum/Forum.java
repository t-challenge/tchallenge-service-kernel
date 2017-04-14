package ru.tsystems.tchallenge.service.kernel.domain.forum;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.domain.event.Event;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SubsequentEntity;

@Entity
public class Forum extends SubsequentEntity {

    @OneToOne
    private Event event;

    public Forum(final Long id) {
        super(id);
    }

    @JpaConstructor
    protected Forum() {

    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(final Event event) {
        this.event = event;
    }
}
