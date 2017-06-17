package ru.tchallenge.service.kernel.domain.task.expectation;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class TaskExpectationFacade extends EnumeratedEntityFacade<TaskExpectation> {

    @Autowired
    private EnumeratedEntityMapper<TaskExpectation> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskExpectation> repository;

    @Override
    protected EnumeratedEntityMapper<TaskExpectation> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskExpectation> getRepository() {
        return repository;
    }
}
