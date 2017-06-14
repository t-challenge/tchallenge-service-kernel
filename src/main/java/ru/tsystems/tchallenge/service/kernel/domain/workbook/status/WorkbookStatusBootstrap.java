package ru.tsystems.tchallenge.service.kernel.domain.workbook.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class WorkbookStatusBootstrap extends EnumeratedEntityBootstrap<WorkbookStatus> {

    @Autowired
    private EnumeratedEntityMapper<WorkbookStatus> mapper;

    @Autowired
    private EnumeratedEntityRepository<WorkbookStatus> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("CREATED", "Создана"));
        invoices.add(enumerated("SUBMITTED", "Отправлена на проверку"));
        invoices.add(enumerated("ASSESSED", "Проверена"));
        invoices.add(enumerated("DISCARDED", "Отменена"));
        invoices.add(enumerated("DELETED", "Удалена"));
    }

    @Override
    protected EnumeratedEntityMapper<WorkbookStatus> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<WorkbookStatus> getRepository() {
        return repository;
    }
}
