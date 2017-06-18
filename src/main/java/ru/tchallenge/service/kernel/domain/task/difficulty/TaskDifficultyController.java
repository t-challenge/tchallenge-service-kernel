package ru.tchallenge.service.kernel.domain.task.difficulty;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/tasks/difficulties")
public class TaskDifficultyController extends EnumeratedEntityController<TaskDifficulty> {

    @Autowired
    private EnumeratedEntityFacade<TaskDifficulty> facade;

    @Override
    protected EnumeratedEntityFacade<TaskDifficulty> getFacade() {
        return facade;
    }
}
