package ru.tsystems.tchallenge.service.kernel.domain.event.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class EventStatusBootstrap extends EnumeratedEntityBootstrap<EventStatus> {

    @Autowired
    private EnumeratedEntityMapper<EventStatus> mapper;

    @Autowired
    private EnumeratedEntityRepository<EventStatus> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("CREATED", "Создано"));
        invoices.add(enumerated("APPROVED", "Подтверждено"));
        invoices.add(enumerated("SUSPENDED", "Приостановлено"));
        invoices.add(enumerated("DELETED", "Удалено"));
    }

    @Override
    protected EnumeratedEntityMapper<EventStatus> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<EventStatus> getRepository() {
        return repository;
    }
}
