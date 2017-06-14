package ru.tsystems.tchallenge.service.kernel.domain.task.image.format;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
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
