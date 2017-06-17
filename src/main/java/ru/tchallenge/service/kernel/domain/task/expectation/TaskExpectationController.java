package ru.tchallenge.service.kernel.domain.task.expectation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/tasks/expectations")
public class TaskExpectationController extends EnumeratedEntityController<TaskExpectation> {

    @Autowired
    private EnumeratedEntityFacade<TaskExpectation> facade;

    @Override
    protected EnumeratedEntityFacade<TaskExpectation> getFacade() {
        return facade;
    }
}
