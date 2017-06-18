package ru.tchallenge.service.kernel.domain.task.image.format;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/tasks/images/formats")
public class TaskImageFormatController extends EnumeratedEntityController<TaskImageFormat> {

    @Autowired
    private EnumeratedEntityFacade<TaskImageFormat> facade;

    @Override
    protected EnumeratedEntityFacade<TaskImageFormat> getFacade() {
        return facade;
    }
}
