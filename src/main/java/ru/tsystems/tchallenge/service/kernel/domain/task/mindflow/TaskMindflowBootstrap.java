package ru.tsystems.tchallenge.service.kernel.domain.task.mindflow;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskMindflowBootstrap extends EnumeratedEntityBootstrap<TaskMindflow> {

    @Autowired
    private TaskMindflowRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("BRAINHECK");
        ids.add("FOUNDATIONS");
        ids.add("ANALYSES");
    }

    @Override
    protected TaskMindflow enumerated(final String id) {
        return new TaskMindflow(id);
    }

    @Override
    protected GenericEntityRepository<TaskMindflow, String> getRepository() {
        return repository;
    }
}
