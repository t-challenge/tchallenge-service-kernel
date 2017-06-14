package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class AccountStatusBootstrap extends EnumeratedEntityBootstrap<AccountStatus> {

    @Autowired
    private EnumeratedEntityMapper<AccountStatus> mapper;

    @Autowired
    private EnumeratedEntityRepository<AccountStatus> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("CREATED", "Создан"));
        invoices.add(enumerated("APPROVED", "Подтвержден"));
        invoices.add(enumerated("SUSPENDED", "Приостановлен"));
        invoices.add(enumerated("DELETED", "Удален"));
    }

    @Override
    protected EnumeratedEntityMapper<AccountStatus> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<AccountStatus> getRepository() {
        return repository;
    }
}
