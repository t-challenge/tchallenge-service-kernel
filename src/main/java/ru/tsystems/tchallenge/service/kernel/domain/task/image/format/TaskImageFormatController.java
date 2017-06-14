package ru.tsystems.tchallenge.service.kernel.domain.task.image.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/tasks/images/formats")
public class TaskImageFormatController extends EnumeratedEntityController<TaskImageFormat> {

    @Autowired
    private EnumeratedEntityFacade<TaskImageFormat> facade;

    @Override
    protected EnumeratedEntityFacade<TaskImageFormat> getFacade() {
        return facade;
    }
}
