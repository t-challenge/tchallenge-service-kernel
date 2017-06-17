package ru.tchallenge.service.kernel.domain.task.ownership;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskOwnershipBootstrap extends EnumeratedEntityBootstrap<TaskOwnership> {

    @Autowired
    private EnumeratedEntityMapper<TaskOwnership> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskOwnership> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("PRIVATE", "Собственная задача"));
        invoices.add(enumerated("PUBLIC", "Взятая из открытых источников"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskOwnership> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskOwnership> getRepository() {
        return repository;
    }
}
