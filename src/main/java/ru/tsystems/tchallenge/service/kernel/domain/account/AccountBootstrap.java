package ru.tsystems.tchallenge.service.kernel.domain.account;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealm;
import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmRepository;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatus;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusRepository;
import ru.tsystems.tchallenge.service.kernel.domain.shared.SequentialBootstrap;

@Component
public class AccountBootstrap extends SequentialBootstrap<Account> {

    @Autowired
    private AccountRealmRepository realmRepository;

    @Autowired
    private AccountStatusRepository statusRepository;

    @Override
    protected void collectEntities(Collection<Account> entities) {
        entities.add(account("first.candidate@email.com", "CANDIDATE"));
        entities.add(account("second.candidate@email.com", "CANDIDATE"));
    }

    private Account account(String email, String realm) {
        Account account = new Account();
        account.setLogin(email);
        account.setEmail(email);
        account.setRealm(realm(realm));
        account.setStatus(status());
        account.setSecretHash(secretHash());
        return account;
    }

    private AccountStatus status() {
        return statusRepository.findById("CREATED");
    }

    private AccountRealm realm(String id) {
        return realmRepository.findById(id);
    }

    private String secretHash() {
        return UUID.randomUUID().toString();
    }
}
