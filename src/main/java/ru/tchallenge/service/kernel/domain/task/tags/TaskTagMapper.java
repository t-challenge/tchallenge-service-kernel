package ru.tchallenge.service.kernel.domain.task.tags;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class TaskTagMapper extends EnumeratedEntityMapper<TaskTag> {

    @Override
    protected TaskTag enumeratedEntity() {
        return new TaskTag();
    }
}
