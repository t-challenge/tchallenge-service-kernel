package ru.tsystems.tchallenge.service.kernel.domain.task.difficulty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskDifficultyBootstrap extends EnumeratedEntityBootstrap<TaskDifficulty> {

    @Autowired
    private TaskDifficultyRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("ELEMENTARY");
        ids.add("EASY");
        ids.add("MEDIUM");
        ids.add("HARD");
        ids.add("ULTIMATE");
    }

    @Override
    protected TaskDifficulty enumerated(final String id) {
        return new TaskDifficulty(id);
    }

    @Override
    protected GenericEntityRepository<TaskDifficulty, String> getRepository() {
        return repository;
    }
}
