package ru.tsystems.tchallenge.service.kernel.domain.task.difficulty;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
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
