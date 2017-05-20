package ru.tsystems.tchallenge.service.kernel.domain.task.ownership;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskOwnershipBootstrap extends EnumeratedEntityBootstrap<TaskOwnership> {

    @Autowired
    private TaskOwnershipRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("PRIVATE");
        ids.add("PUBLIC");
    }

    @Override
    protected TaskOwnership enumerated(final String id) {
        return new TaskOwnership(id);
    }

    @Override
    protected GenericEntityRepository<TaskOwnership, String> getRepository() {
        return repository;
    }
}
