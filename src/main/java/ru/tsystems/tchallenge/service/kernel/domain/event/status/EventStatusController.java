package ru.tsystems.tchallenge.service.kernel.domain.event.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/events/statuses")
public class EventStatusController extends EnumeratedEntityController<EventStatus> {

    @Autowired
    private EnumeratedEntityFacade<EventStatus> facade;

    @Override
    protected EnumeratedEntityFacade<EventStatus> getFacade() {
        return facade;
    }
}
