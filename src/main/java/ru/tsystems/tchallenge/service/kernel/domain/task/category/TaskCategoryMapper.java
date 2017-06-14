package ru.tsystems.tchallenge.service.kernel.domain.task.category;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskCategoryMapper extends EnumeratedEntityMapper<TaskCategory> {

    @Override
    protected TaskCategory enumeratedEntity() {
        return new TaskCategory();
    }
}
