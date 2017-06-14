package ru.tsystems.tchallenge.service.kernel.domain.task.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
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
