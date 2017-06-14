package ru.tsystems.tchallenge.service.kernel.domain.assignment.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class AssignmentStatusBootstrap extends EnumeratedEntityBootstrap<AssignmentStatus> {

    @Autowired
    private EnumeratedEntityMapper<AssignmentStatus> mapper;

    @Autowired
    private EnumeratedEntityRepository<AssignmentStatus> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("CREATED", "Создано"));
        invoices.add(enumerated("SUBMITTED", "Отправлено на проверку"));
        invoices.add(enumerated("ASSESSED", "Проверено"));
    }

    @Override
    protected EnumeratedEntityMapper<AssignmentStatus> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<AssignmentStatus> getRepository() {
        return repository;
    }
}
