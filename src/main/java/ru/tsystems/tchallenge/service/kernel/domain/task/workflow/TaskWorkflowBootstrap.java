package ru.tsystems.tchallenge.service.kernel.domain.task.workflow;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskWorkflowBootstrap extends EnumeratedEntityBootstrap<TaskWorkflow> {

    @Autowired
    private TaskWorkflowRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("EXPERT");
        ids.add("MACHINE");
        ids.add("MIXED");
    }

    @Override
    protected TaskWorkflow enumerated(final String id) {
        return new TaskWorkflow(id);
    }

    @Override
    protected GenericEntityRepository<TaskWorkflow, String> getRepository() {
        return repository;
    }
}
