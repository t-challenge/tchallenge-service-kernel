package ru.tsystems.tchallenge.service.kernel.domain.account;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmRepository;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusRepository;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.OrdinalEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;
import ru.tsystems.tchallenge.service.kernel.utility.encryption.EncryptionService;

@BootstrapComponent
public class AccountBootstrap extends OrdinalEntityBootstrap<Account> {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private AccountRealmRepository realmRepository;

    @Autowired
    private AccountStatusRepository statusRepository;

    @Autowired
    private AccountRealmBootstrap realmBootstrap;

    @Autowired
    private AccountStatusBootstrap statusBootstrap;

    @Autowired
    private EncryptionService encryptionService;

    @Override
    protected void collectEntities(final Collection<Account> entities) {
        entities.add(sidorov());
        entities.add(petrov());
        entities.add(kuznetcov());
        entities.add(systemA());
    }

    @Override
    protected GenericEntityRepository<Account, Long> getRepository() {
        return repository;
    }

    private Account sidorov() {
        return candidate("egor.sidorov@some-email.com", "APPROVED");
    }

    private Account petrov() {
        return employee("ivan.petrov@some-email.com", "APPROVED");
    }

    private Account kuznetcov() {
        return employee("sergei.kuznetcov@some-email.com", "APPROVED");
    }

    private Account systemA() {
        return system("system.a@some-email.com", "APPROVED");
    }

    private Account candidate(final String email, final String status) {
        return account(email, "CANDIDATE", status);
    }

    private Account employee(final String email, final String status) {
        return account(email, "EMPLOYEE", status);
    }

    private Account system(final String email, final String status) {
        return account(email, "SYSTEM", status);
    }

    private Account account(final String email,
                            final String realm,
                            final String status) {
        final Account account = new Account();
        account.setEmail(email);
        account.setLogin(email);
        account.setSecretHash(accountSecretHash(email));
        account.setRealm(realmRepository.findById(realm));
        account.setStatus(statusRepository.findById(status));
        return account;
    }

    private String accountSecretHash(final String login) {
        return encryptionService.accountSecretHash(login + "123");
    }
}
