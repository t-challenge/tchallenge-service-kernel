package ru.tsystems.tchallenge.service.kernel.domain.assignment.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class AssignmentStatusBootstrap extends EnumeratedEntityBootstrap<AssignmentStatus> {

    @Autowired
    private AssignmentStatusRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("CREATED");
        ids.add("SUBMITTED");
        ids.add("ASSESSED");
    }

    @Override
    protected AssignmentStatus enumerated(final String id) {
        return new AssignmentStatus(id);
    }

    @Override
    protected GenericEntityRepository<AssignmentStatus, String> getRepository() {
        return repository;
    }
}
