package ru.tsystems.tchallenge.service.kernel.domain.sample.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class SampleStatusBootstrap extends EnumeratedEntityBootstrap<SampleStatus> {

    @Autowired
    private SampleStatusRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("CREATED");
        ids.add("APPROVED");
        ids.add("BLOCKED");
    }

    @Override
    protected SampleStatus enumerated(final String id) {
        return new SampleStatus(id);
    }

    @Override
    protected GenericEntityRepository<SampleStatus, String> getRepository() {
        return repository;
    }
}
