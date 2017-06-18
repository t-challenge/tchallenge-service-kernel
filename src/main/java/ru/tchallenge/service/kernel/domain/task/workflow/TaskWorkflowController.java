package ru.tchallenge.service.kernel.domain.task.workflow;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/tasks/workflows")
public class TaskWorkflowController extends EnumeratedEntityController<TaskWorkflow> {

    @Autowired
    private EnumeratedEntityFacade<TaskWorkflow> facade;

    @Override
    protected EnumeratedEntityFacade<TaskWorkflow> getFacade() {
        return facade;
    }
}
