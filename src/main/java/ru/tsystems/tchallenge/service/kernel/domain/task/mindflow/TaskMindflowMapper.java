package ru.tsystems.tchallenge.service.kernel.domain.task.mindflow;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.domain.task.ownership.TaskOwnership;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskMindflowMapper extends EnumeratedEntityMapper<TaskMindflow> {

    @Override
    protected TaskMindflow enumeratedEntity() {
        return new TaskMindflow();
    }
}
