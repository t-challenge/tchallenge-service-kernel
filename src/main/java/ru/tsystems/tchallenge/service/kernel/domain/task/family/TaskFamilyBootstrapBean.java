package ru.tsystems.tchallenge.service.kernel.domain.task.family;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskFamilyBootstrapBean extends EnumeratedEntityBootstrap<TaskFamily> {

    @Autowired
    private TaskFamilyRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("MOOR-LAW");
        ids.add("CYPHER-LAW");
    }

    @Override
    protected TaskFamily enumerated(final String id) {
        return new TaskFamily(id);
    }

    @Override
    protected GenericEntityRepository<TaskFamily, String> getRepository() {
        return repository;
    }
}
