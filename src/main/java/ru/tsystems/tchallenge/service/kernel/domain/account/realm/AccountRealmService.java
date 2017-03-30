package ru.tsystems.tchallenge.service.kernel.domain.account.realm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityRepository;
import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityService;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountRealmService extends EnumeratedEntityService<AccountRealm> {

    @Autowired
    private AccountRealmRepository accountRealmRepository;

    @Override
    protected EnumeratedEntityRepository<AccountRealm> getRepository() {
        return accountRealmRepository;
    }

    @Override
    protected AccountRealm enumerated(String id) {
        return new AccountRealm(id);
    }
}
