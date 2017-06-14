package ru.tsystems.tchallenge.service.kernel.domain.task.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskStatusBootstrap extends EnumeratedEntityBootstrap<TaskStatus> {

    @Autowired
    private EnumeratedEntityMapper<TaskStatus> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskStatus> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("CREATED", "Создана"));
        invoices.add(enumerated("APPROVED", "Подтверждена"));
        invoices.add(enumerated("SUSPENDED", "Приостановлена"));
        invoices.add(enumerated("BLACKLISTED", "В черном списке"));
        invoices.add(enumerated("DELETED", "Удалена"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskStatus> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskStatus> getRepository() {
        return repository;
    }
}
