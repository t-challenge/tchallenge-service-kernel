package ru.tchallenge.service.kernel.domain.task.mindflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/tasks/mindflows")
public class TaskMindflowController extends EnumeratedEntityController<TaskMindflow> {

    @Autowired
    private EnumeratedEntityFacade<TaskMindflow> facade;

    @Override
    protected EnumeratedEntityFacade<TaskMindflow> getFacade() {
        return facade;
    }
}
