package ru.tsystems.tchallenge.service.kernel.domain.event.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/events/categories")
public class EventCategoryController extends EnumeratedEntityController<EventCategory> {

    @Autowired
    private EnumeratedEntityFacade<EventCategory> facade;

    @Override
    protected EnumeratedEntityFacade<EventCategory> getFacade() {
        return facade;
    }
}
