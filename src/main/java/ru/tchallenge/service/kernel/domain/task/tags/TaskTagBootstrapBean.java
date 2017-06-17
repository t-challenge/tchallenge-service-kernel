package ru.tchallenge.service.kernel.domain.task.tags;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskTagBootstrapBean extends EnumeratedEntityBootstrap<TaskTag> {

    @Autowired
    private EnumeratedEntityMapper<TaskTag> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskTag> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("TAG1", "тестовая метка 1"));
        invoices.add(enumerated("TAG2", "тестовая метка 2"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskTag> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskTag> getRepository() {
        return repository;
    }
}
