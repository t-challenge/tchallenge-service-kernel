package ru.tchallenge.service.kernel.domain.task.family;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class TaskFamilyMapper extends EnumeratedEntityMapper<TaskFamily> {

    @Override
    protected TaskFamily enumeratedEntity() {
        return new TaskFamily();
    }
}
