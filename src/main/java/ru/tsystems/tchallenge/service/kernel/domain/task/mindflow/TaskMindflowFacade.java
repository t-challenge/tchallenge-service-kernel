package ru.tsystems.tchallenge.service.kernel.domain.task.mindflow;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class TaskMindflowFacade extends EnumeratedEntityFacade<TaskMindflow> {

    @Autowired
    private EnumeratedEntityMapper<TaskMindflow> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskMindflow> repository;

    @Override
    protected EnumeratedEntityMapper<TaskMindflow> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskMindflow> getRepository() {
        return repository;
    }
}
