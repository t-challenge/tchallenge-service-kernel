package ru.tchallenge.service.kernel.domain.event.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/events/statuses")
public class EventStatusController extends EnumeratedEntityController<EventStatus> {

    @Autowired
    private EnumeratedEntityFacade<EventStatus> facade;

    @Override
    protected EnumeratedEntityFacade<EventStatus> getFacade() {
        return facade;
    }
}
