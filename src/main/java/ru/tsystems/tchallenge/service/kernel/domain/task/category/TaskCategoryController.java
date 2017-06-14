package ru.tsystems.tchallenge.service.kernel.domain.task.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/tasks/categories")
public class TaskCategoryController extends EnumeratedEntityController<TaskCategory> {

    @Autowired
    private EnumeratedEntityFacade<TaskCategory> facade;

    @Override
    protected EnumeratedEntityFacade<TaskCategory> getFacade() {
        return facade;
    }
}
