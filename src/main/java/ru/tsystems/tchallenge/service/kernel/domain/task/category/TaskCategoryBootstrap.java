package ru.tsystems.tchallenge.service.kernel.domain.task.category;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskCategoryBootstrap extends EnumeratedEntityBootstrap<TaskCategory> {

    @Autowired
    private TaskCategoryRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("COMMON");
        ids.add("JAVA");
        ids.add("JAVASCRIPT");
        ids.add("SQL");
        ids.add("TEST");
        ids.add("HTML");
        ids.add("CSS");
        ids.add("OOD");
        ids.add("THREADS");
        ids.add("ALGORITHMS");
    }

    @Override
    protected TaskCategory enumerated(final String id) {
        return new TaskCategory(id);
    }

    @Override
    protected GenericEntityRepository<TaskCategory, String> getRepository() {
        return repository;
    }
}
