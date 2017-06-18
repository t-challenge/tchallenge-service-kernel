package ru.tchallenge.service.kernel.domain.task.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@ServiceComponent
public class TaskStatusFacade extends EnumeratedEntityFacade<TaskStatus> {

    @Autowired
    private EnumeratedEntityMapper<TaskStatus> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskStatus> repository;

    @Override
    protected EnumeratedEntityMapper<TaskStatus> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskStatus> getRepository() {
        return repository;
    }
}
