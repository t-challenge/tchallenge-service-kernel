package ru.tsystems.tchallenge.service.kernel.domain.event.category;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class EventCategoryBootstrap extends EnumeratedEntityBootstrap<EventCategory> {

    @Autowired
    private EnumeratedEntityMapper<EventCategory> mapper;

    @Autowired
    private EnumeratedEntityRepository<EventCategory> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("FORUM", "Конференция"));
        invoices.add(enumerated("INTERVIEW", "Собеседование"));
        invoices.add(enumerated("SCREENING", "Предварительный отбор"));
    }

    @Override
    protected EnumeratedEntityMapper<EventCategory> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<EventCategory> getRepository() {
        return repository;
    }
}
