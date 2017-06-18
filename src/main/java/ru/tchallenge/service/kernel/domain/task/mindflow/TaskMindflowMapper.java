package ru.tchallenge.service.kernel.domain.task.mindflow;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class TaskMindflowMapper extends EnumeratedEntityMapper<TaskMindflow> {

    @Override
    protected TaskMindflow enumeratedEntity() {
        return new TaskMindflow();
    }
}
