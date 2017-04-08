package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class AccountStatusBootstrap extends EnumeratedEntityBootstrap<AccountStatus> {

    @Autowired
    private AccountStatusRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("CREATED");
        ids.add("APPROVED");
        ids.add("SUSPENDED");
        ids.add("BLOCKED");
    }

    @Override
    protected AccountStatus enumerated(final String id) {
        return new AccountStatus(id);
    }

    @Override
    protected GenericEntityRepository<AccountStatus, String> getRepository() {
        return repository;
    }
}
