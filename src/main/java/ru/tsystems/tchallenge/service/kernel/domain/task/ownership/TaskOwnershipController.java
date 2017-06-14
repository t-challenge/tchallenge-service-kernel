package ru.tsystems.tchallenge.service.kernel.domain.task.ownership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/tasks/ownerships")
public class TaskOwnershipController extends EnumeratedEntityController<TaskOwnership> {

    @Autowired
    private EnumeratedEntityFacade<TaskOwnership> facade;

    @Override
    protected EnumeratedEntityFacade<TaskOwnership> getFacade() {
        return facade;
    }
}
