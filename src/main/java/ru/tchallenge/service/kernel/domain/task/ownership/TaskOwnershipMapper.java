package ru.tchallenge.service.kernel.domain.task.ownership;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class TaskOwnershipMapper extends EnumeratedEntityMapper<TaskOwnership> {

    @Override
    protected TaskOwnership enumeratedEntity() {
        return new TaskOwnership();
    }
}
