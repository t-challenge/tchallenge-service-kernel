package ru.tsystems.tchallenge.service.kernel.domain.account;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.CommonService;
import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealm;
import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmRepository;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatus;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusRepository;
import ru.tsystems.tchallenge.service.kernel.generic.GenericService;
import ru.tsystems.tchallenge.service.kernel.utility.encryption.EncryptionService;

@CommonService
public class AccountServiceBean extends GenericService implements AccountService {

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

    @Override
    public AccountInfo create(final AccountInvoice invoice) {
        final Account account = createFromInvoice(invoice);
        return saveAndInfo(account);
    }

    @Override
    public AccountInfo getByLogin(final String login) {
        final Account account = findByLogin(login);
        return info(account);
    }

    @Override
    public AccountInfo updateEmail(final String login, final String newEmail) {
        final Account account = findByLogin(login);
        account.setEmail(newEmail);
        return saveAndInfo(account);
    }

    @Override
    public AccountInfo updateLogin(final String login, final String newLogin) {
        final Account account = findByLogin(login);
        account.setLogin(newLogin);
        return saveAndInfo(account);
    }

    @Override
    public AccountInfo updateSecret(final String login, final String newSecret) {
        final Account account = findByLogin(login);
        account.setSecretHash(secretHash(newSecret));
        return saveAndInfo(account);
    }

    @Override
    public AccountInfo updateStatus(final String login, final String newStatus) {
        final Account account = findByLogin(login);
        account.setStatus(status(newStatus));
        return saveAndInfo(account);
    }

    private Account createFromInvoice(final AccountInvoice accountProperties) {
        Account account = new Account();
        account.setEmail(accountProperties.getEmail());
        account.setLogin(accountProperties.getLogin());
        account.setRealm(realm(accountProperties.getRealm()));
        account.setStatus(statusCreated());
        account.setSecretHash(secretHash(accountProperties.getSecret()));
        return account;
    }

    private Account findByLogin(final String login) {
        return accountRepository.findByLogin(login);
    }

    private AccountInfo info(final Account account) {
        return accountMapper.accountInfo(account);
    }

    private AccountInfo saveAndInfo(final Account account) {
        accountRepository.save(account);
        return info(account);
    }

    private String secretHash(final String secret) {
        return encryptionService.accountSecretHash(secret);
    }

    private AccountRealm realm(final String realmId) {
        return accountRealmRepository.findById(realmId);
    }

    private AccountStatus status(final String statusId) {
        return accountStatusRepository.findById(statusId);
    }

    private AccountStatus statusCreated() {
        return status("CREATED");
    }
}
