package ru.tchallenge.service.kernel.domain.event.category;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/events/categories")
public class EventCategoryController extends EnumeratedEntityController<EventCategory> {

    @Autowired
    private EnumeratedEntityFacade<EventCategory> facade;

    @Override
    protected EnumeratedEntityFacade<EventCategory> getFacade() {
        return facade;
    }
}
