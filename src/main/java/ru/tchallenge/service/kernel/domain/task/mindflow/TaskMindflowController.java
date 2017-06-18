package ru.tchallenge.service.kernel.domain.task.mindflow;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/tasks/mindflows")
public class TaskMindflowController extends EnumeratedEntityController<TaskMindflow> {

    @Autowired
    private EnumeratedEntityFacade<TaskMindflow> facade;

    @Override
    protected EnumeratedEntityFacade<TaskMindflow> getFacade() {
        return facade;
    }
}
