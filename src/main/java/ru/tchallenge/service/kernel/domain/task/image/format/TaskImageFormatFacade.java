package ru.tchallenge.service.kernel.domain.task.image.format;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@ServiceComponent
public class TaskImageFormatFacade extends EnumeratedEntityFacade<TaskImageFormat> {

    @Autowired
    private EnumeratedEntityMapper<TaskImageFormat> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskImageFormat> repository;

    @Override
    protected EnumeratedEntityMapper<TaskImageFormat> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskImageFormat> getRepository() {
        return repository;
    }
}
