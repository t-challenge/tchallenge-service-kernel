package ru.tsystems.tchallenge.service.kernel.domain.task.difficulty;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskDifficultyMapper extends EnumeratedEntityMapper<TaskDifficulty> {

    @Override
    protected TaskDifficulty enumeratedEntity() {
        return new TaskDifficulty();
    }
}