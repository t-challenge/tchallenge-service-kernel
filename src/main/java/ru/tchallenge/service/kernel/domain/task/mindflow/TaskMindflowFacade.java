package ru.tchallenge.service.kernel.domain.task.mindflow;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@ServiceComponent
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
