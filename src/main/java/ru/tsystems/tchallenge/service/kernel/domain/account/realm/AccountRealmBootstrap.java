package ru.tsystems.tchallenge.service.kernel.domain.account.realm;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@Component
public class AccountRealmBootstrap extends EnumeratedEntityBootstrap<AccountRealm> {

    @Autowired
    private AccountRealmRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("CANDIDATE");
        ids.add("EMPLOYEE");
        ids.add("SYSTEM");
    }

    @Override
    protected AccountRealm enumerated(final String id) {
        return new AccountRealm(id);
    }

    @Override
    protected GenericEntityRepository<AccountRealm, String> getRepository() {
        return repository;
    }
}
