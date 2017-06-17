package ru.tchallenge.service.kernel.domain.account.realm;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class AccountRealmBootstrap extends EnumeratedEntityBootstrap<AccountRealm> {

    @Autowired
    private EnumeratedEntityMapper<AccountRealm> mapper;

    @Autowired
    private EnumeratedEntityRepository<AccountRealm> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("CANDIDATE", "Внешний кандидат"));
        invoices.add(enumerated("EMPLOYEE", "Сотрудник компании"));
        invoices.add(enumerated("ROBOT", "Сервис или сторонее приложение"));
    }

    @Override
    protected EnumeratedEntityMapper<AccountRealm> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<AccountRealm> getRepository() {
        return repository;
    }
}
