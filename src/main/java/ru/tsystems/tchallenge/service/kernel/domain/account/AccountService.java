package ru.tsystems.tchallenge.service.kernel.domain.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealm;
import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmRepository;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatus;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusRepository;
import ru.tsystems.tchallenge.service.kernel.generic.GenericService;
import ru.tsystems.tchallenge.service.kernel.utility.encryption.EncryptionService;

@Service
public class AccountService extends GenericService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRealmRepository accountRealmRepository;

    @Autowired
    private AccountStatusRepository accountStatusRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private EncryptionService encryptionService;

    public AccountInfo create(AccountInvoice accountProperties) {
        Account account = accountFromProperties(accountProperties);
        return save(account);
    }

    public AccountInfo getByLogin(String login) {
        Account account = accountByLogin(login);
        return accountInfo(account);
    }

    public AccountInfo updateEmail(String login, String newEmail) {
        Account account = accountByLogin(login);
        account.setEmail(newEmail);
        return save(account);
    }

    public AccountInfo updateLogin(String login, String newLogin) {
        Account account = accountByLogin(login);
        account.setLogin(newLogin);
        return save(account);
    }

    public AccountInfo updateSecret(String login, String newSecret) {
        Account account = accountByLogin(login);
        account.setSecretHash(secretHash(newSecret));
        return save(account);
    }

    public AccountInfo updateStatus(String login, String newStatus) {
        Account account = accountByLogin(login);
        account.setStatus(status(newStatus));
        return save(account);
    }

    private Account accountByLogin(String login) {
        return accountRepository.findByLogin(login);
    }

    private Account accountFromProperties(AccountInvoice accountProperties) {
        Account account = new Account();
        account.setEmail(accountProperties.getEmail());
        account.setLogin(accountProperties.getLogin());
        account.setRealm(realm(accountProperties.getRealm()));
        account.setStatus(statusCreated());
        account.setSecretHash(secretHash(accountProperties.getSecret()));
        return account;
    }

    private AccountInfo save(Account account) {
        accountRepository.save(account);
        return accountInfo(account);
    }

    private AccountInfo accountInfo(Account account) {
        return accountMapper.accountInfo(account);
    }

    private String secretHash(String secret) {
        return encryptionService.accountSecretHash(secret);
    }

    private AccountRealm realm(String realmId) {
        return accountRealmRepository.findById(realmId);
    }

    private AccountStatus status(String statusId) {
        return accountStatusRepository.findById(statusId);
    }

    private AccountStatus statusCreated() {
        return status("CREATED");
    }
}
