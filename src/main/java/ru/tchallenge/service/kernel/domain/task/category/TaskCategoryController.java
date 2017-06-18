package ru.tchallenge.service.kernel.domain.task.category;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/tasks/categories")
public class TaskCategoryController extends EnumeratedEntityController<TaskCategory> {

    @Autowired
    private EnumeratedEntityFacade<TaskCategory> facade;

    @Override
    protected EnumeratedEntityFacade<TaskCategory> getFacade() {
        return facade;
    }
}
