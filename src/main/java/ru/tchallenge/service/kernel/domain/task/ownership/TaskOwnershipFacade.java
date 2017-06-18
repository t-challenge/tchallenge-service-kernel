package ru.tchallenge.service.kernel.domain.task.ownership;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@ServiceComponent
public class TaskOwnershipFacade extends EnumeratedEntityFacade<TaskOwnership> {

    @Autowired
    private EnumeratedEntityMapper<TaskOwnership> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskOwnership> repository;

    @Override
    protected EnumeratedEntityMapper<TaskOwnership> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskOwnership> getRepository() {
        return repository;
    }
}
