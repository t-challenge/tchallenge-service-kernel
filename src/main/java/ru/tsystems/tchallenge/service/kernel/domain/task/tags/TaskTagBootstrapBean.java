package ru.tsystems.tchallenge.service.kernel.domain.task.tags;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskTagBootstrapBean extends EnumeratedEntityBootstrap<TaskTag> {

    @Autowired
    private TaskTagRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("TAG1");
        ids.add("TAG2");
    }

    @Override
    protected TaskTag enumerated(final String id) {
        return new TaskTag(id);
    }

    @Override
    protected GenericEntityRepository<TaskTag, String> getRepository() {
        return repository;
    }
}
