package ru.tchallenge.service.kernel.domain.task.expectation;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/tasks/expectations")
public class TaskExpectationController extends EnumeratedEntityController<TaskExpectation> {

    @Autowired
    private EnumeratedEntityFacade<TaskExpectation> facade;

    @Override
    protected EnumeratedEntityFacade<TaskExpectation> getFacade() {
        return facade;
    }
}
