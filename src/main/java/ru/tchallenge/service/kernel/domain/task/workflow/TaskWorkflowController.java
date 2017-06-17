package ru.tchallenge.service.kernel.domain.task.workflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/tasks/workflows")
public class TaskWorkflowController extends EnumeratedEntityController<TaskWorkflow> {

    @Autowired
    private EnumeratedEntityFacade<TaskWorkflow> facade;

    @Override
    protected EnumeratedEntityFacade<TaskWorkflow> getFacade() {
        return facade;
    }
}
