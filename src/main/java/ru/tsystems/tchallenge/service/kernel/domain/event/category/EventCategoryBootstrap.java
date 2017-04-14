package ru.tsystems.tchallenge.service.kernel.domain.event.category;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class EventCategoryBootstrap extends EnumeratedEntityBootstrap<EventCategory> {

    @Autowired
    private EventCategoryRepository repository;

    @Override
    protected void collectIds(final Collection<String> categories) {
        categories.add("FORUM");
        categories.add("SCREENING");
        categories.add("INTERVIEW");
    }

    @Override
    protected EventCategory enumerated(final String id) {
        return new EventCategory(id);
    }

    @Override
    protected GenericEntityRepository<EventCategory, String> getRepository() {
        return repository;
    }
}
