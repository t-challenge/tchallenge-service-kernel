package ru.tsystems.tchallenge.service.kernel.domain.task.ownership;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskOwnershipMapper extends EnumeratedEntityMapper<TaskOwnership> {

    @Override
    protected TaskOwnership enumeratedEntity() {
        return new TaskOwnership();
    }
}
