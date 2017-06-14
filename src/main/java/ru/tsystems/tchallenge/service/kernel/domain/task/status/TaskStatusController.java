package ru.tsystems.tchallenge.service.kernel.domain.task.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/tasks/statuses")
public class TaskStatusController extends EnumeratedEntityController<TaskStatus> {

    @Autowired
    private EnumeratedEntityFacade<TaskStatus> facade;

    @Override
    protected EnumeratedEntityFacade<TaskStatus> getFacade() {
        return facade;
    }
}
