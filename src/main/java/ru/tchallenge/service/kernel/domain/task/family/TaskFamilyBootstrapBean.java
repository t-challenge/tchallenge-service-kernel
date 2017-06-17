package ru.tchallenge.service.kernel.domain.task.family;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskFamilyBootstrapBean extends EnumeratedEntityBootstrap<TaskFamily> {

    @Autowired
    private EnumeratedEntityMapper<TaskFamily> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskFamily> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("MOOR-LAW", "Moor law"));
        invoices.add(enumerated("CYPHER-LAW", "Cypher law"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskFamily> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskFamily> getRepository() {
        return repository;
    }
}
