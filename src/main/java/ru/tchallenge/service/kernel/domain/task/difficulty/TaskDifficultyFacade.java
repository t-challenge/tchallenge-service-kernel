package ru.tchallenge.service.kernel.domain.task.difficulty;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@ServiceComponent
public class TaskDifficultyFacade extends EnumeratedEntityFacade<TaskDifficulty> {

    @Autowired
    private EnumeratedEntityMapper<TaskDifficulty> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskDifficulty> repository;

    @Override
    protected EnumeratedEntityMapper<TaskDifficulty> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskDifficulty> getRepository() {
        return repository;
    }
}
