package ru.tchallenge.service.kernel.domain.task.status;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class TaskStatusMapper extends EnumeratedEntityMapper<TaskStatus> {

    @Override
    protected TaskStatus enumeratedEntity() {
        return new TaskStatus();
    }
}
