package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityRepository;
import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityService;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountStatusService extends EnumeratedEntityService<AccountStatus> {

    @Autowired
    private AccountStatusRepository accountStatusRepository;

    @Override
    protected EnumeratedEntityRepository<AccountStatus> getRepository() {
        return accountStatusRepository;
    }

    @Override
    protected AccountStatus enumerated(String id) {
        return new AccountStatus(id);
    }
}
