package ru.tsystems.tchallenge.service.kernel.domain.task.ownership;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
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
