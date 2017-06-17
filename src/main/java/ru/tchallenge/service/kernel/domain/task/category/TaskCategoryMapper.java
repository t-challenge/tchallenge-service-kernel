package ru.tchallenge.service.kernel.domain.task.category;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskCategoryMapper extends EnumeratedEntityMapper<TaskCategory> {

    @Override
    protected TaskCategory enumeratedEntity() {
        return new TaskCategory();
    }
}
