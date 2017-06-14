package ru.tsystems.tchallenge.service.kernel.domain.task.family;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskFamilyMapper extends EnumeratedEntityMapper<TaskFamily> {

    @Override
    protected TaskFamily enumeratedEntity() {
        return new TaskFamily();
    }
}
