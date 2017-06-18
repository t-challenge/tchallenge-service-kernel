package ru.tchallenge.service.kernel.domain.task.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/tasks/statuses")
public class TaskStatusController extends EnumeratedEntityController<TaskStatus> {

    @Autowired
    private EnumeratedEntityFacade<TaskStatus> facade;

    @Override
    protected EnumeratedEntityFacade<TaskStatus> getFacade() {
        return facade;
    }
}
