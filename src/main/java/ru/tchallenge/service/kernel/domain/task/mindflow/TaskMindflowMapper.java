package ru.tchallenge.service.kernel.domain.task.mindflow;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskMindflowMapper extends EnumeratedEntityMapper<TaskMindflow> {

    @Override
    protected TaskMindflow enumeratedEntity() {
        return new TaskMindflow();
    }
}
