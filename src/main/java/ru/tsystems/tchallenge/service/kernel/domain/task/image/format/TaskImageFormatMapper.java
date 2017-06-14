package ru.tsystems.tchallenge.service.kernel.domain.task.image.format;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskImageFormatMapper extends EnumeratedEntityMapper<TaskImageFormat> {

    @Override
    protected TaskImageFormat enumeratedEntity() {
        return new TaskImageFormat();
    }
}
