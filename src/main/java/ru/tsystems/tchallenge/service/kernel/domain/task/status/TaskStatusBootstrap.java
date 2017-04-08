package ru.tsystems.tchallenge.service.kernel.domain.task.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskStatusBootstrap extends EnumeratedEntityBootstrap<TaskStatus> {

    @Autowired
    private TaskStatusRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("CREATED");
        ids.add("APPROVED");
        ids.add("SUSPENDED");
        ids.add("BLACKLISTED");
        ids.add("DELETED");
    }

    @Override
    protected TaskStatus enumerated(final String id) {
        return new TaskStatus(id);
    }

    @Override
    protected GenericEntityRepository<TaskStatus, String> getRepository() {
        return repository;
    }
}
