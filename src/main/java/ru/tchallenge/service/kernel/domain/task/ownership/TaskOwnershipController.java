package ru.tchallenge.service.kernel.domain.task.ownership;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/tasks/ownerships")
public class TaskOwnershipController extends EnumeratedEntityController<TaskOwnership> {

    @Autowired
    private EnumeratedEntityFacade<TaskOwnership> facade;

    @Override
    protected EnumeratedEntityFacade<TaskOwnership> getFacade() {
        return facade;
    }
}
