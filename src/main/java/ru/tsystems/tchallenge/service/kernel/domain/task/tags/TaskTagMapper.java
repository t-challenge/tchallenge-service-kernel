package ru.tsystems.tchallenge.service.kernel.domain.task.tags;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskTagMapper extends EnumeratedEntityMapper<TaskTag> {

    @Override
    protected TaskTag enumeratedEntity() {
        return new TaskTag();
    }
}
