package ru.tchallenge.service.kernel.domain.task.status;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskStatusMapper extends EnumeratedEntityMapper<TaskStatus> {

    @Override
    protected TaskStatus enumeratedEntity() {
        return new TaskStatus();
    }
}
