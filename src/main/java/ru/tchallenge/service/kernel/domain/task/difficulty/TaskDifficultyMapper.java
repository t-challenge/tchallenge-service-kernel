package ru.tchallenge.service.kernel.domain.task.difficulty;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class TaskDifficultyMapper extends EnumeratedEntityMapper<TaskDifficulty> {

    @Override
    protected TaskDifficulty enumeratedEntity() {
        return new TaskDifficulty();
    }
}
