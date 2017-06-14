package ru.tsystems.tchallenge.service.kernel.domain.task.difficulty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/tasks/difficulties")
public class TaskDifficultyController extends EnumeratedEntityController<TaskDifficulty> {

    @Autowired
    private EnumeratedEntityFacade<TaskDifficulty> facade;

    @Override
    protected EnumeratedEntityFacade<TaskDifficulty> getFacade() {
        return facade;
    }
}
