package ru.tsystems.tchallenge.service.kernel.domain.task.workflow;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class TaskWorkflowFacade extends EnumeratedEntityFacade<TaskWorkflow> {

    @Autowired
    private EnumeratedEntityMapper<TaskWorkflow> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskWorkflow> repository;

    @Override
    protected EnumeratedEntityMapper<TaskWorkflow> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskWorkflow> getRepository() {
        return repository;
    }
}
