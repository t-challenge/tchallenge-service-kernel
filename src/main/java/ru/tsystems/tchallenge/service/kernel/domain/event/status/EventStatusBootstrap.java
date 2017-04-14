package ru.tsystems.tchallenge.service.kernel.domain.event.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class EventStatusBootstrap extends EnumeratedEntityBootstrap<EventStatus> {

    @Autowired
    private EventStatusRepository repository;

    @Override
    protected void collectIds(final Collection<String> statuses) {
        statuses.add("CREATED");
        statuses.add("APPROVED");
        statuses.add("SUSPENDED");
        statuses.add("DELETED");
    }

    @Override
    protected EventStatus enumerated(final String id) {
        return new EventStatus(id);
    }

    @Override
    protected GenericEntityRepository<EventStatus, String> getRepository() {
        return repository;
    }
}
