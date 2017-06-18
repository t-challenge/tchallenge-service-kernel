package ru.tchallenge.service.kernel.domain.task.category;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class TaskCategoryMapper extends EnumeratedEntityMapper<TaskCategory> {

    @Override
    protected TaskCategory enumeratedEntity() {
        return new TaskCategory();
    }
}
