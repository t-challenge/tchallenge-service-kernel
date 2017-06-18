package ru.tchallenge.service.kernel.domain.task.image.format;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class TaskImageFormatMapper extends EnumeratedEntityMapper<TaskImageFormat> {

    @Override
    protected TaskImageFormat enumeratedEntity() {
        return new TaskImageFormat();
    }
}
