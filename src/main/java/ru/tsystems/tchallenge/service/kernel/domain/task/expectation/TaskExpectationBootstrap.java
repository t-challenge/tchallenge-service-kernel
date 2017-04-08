package ru.tsystems.tchallenge.service.kernel.domain.task.expectation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskExpectationBootstrap extends EnumeratedEntityBootstrap<TaskExpectation> {

    @Autowired
    private TaskExpectationRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("SINGLESELECT");
        ids.add("MULTISELECT");
        ids.add("SMALLINPUT");
        ids.add("LARGEINPUT");
    }

    @Override
    protected TaskExpectation enumerated(final String id) {
        return new TaskExpectation(id);
    }

    @Override
    protected GenericEntityRepository<TaskExpectation, String> getRepository() {
        return repository;
    }
}
