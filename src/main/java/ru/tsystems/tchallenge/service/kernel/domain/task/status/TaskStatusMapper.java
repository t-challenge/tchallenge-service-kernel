package ru.tsystems.tchallenge.service.kernel.domain.task.status;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskStatusMapper extends EnumeratedEntityMapper<TaskStatus> {

    @Override
    protected TaskStatus enumeratedEntity() {
        return new TaskStatus();
    }
}
