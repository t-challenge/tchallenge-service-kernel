package ru.tchallenge.service.kernel.domain.task.category;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class TaskCategoryFacade extends EnumeratedEntityFacade<TaskCategory> {

    @Autowired
    private EnumeratedEntityMapper<TaskCategory> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskCategory> repository;

    @Override
    protected EnumeratedEntityMapper<TaskCategory> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskCategory> getRepository() {
        return repository;
    }
}
