package ru.tchallenge.service.kernel.domain.forum;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ru.tchallenge.service.kernel.domain.event.Event;
import ru.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Forum extends SequentialEntity {

    @OneToOne
    private Event event;

    public Forum() {

    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(final Event event) {
        this.event = event;
    }
}
