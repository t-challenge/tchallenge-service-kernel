package ru.tsystems.tchallenge.service.kernel.domain.account;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.CommonService;
import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmRepository;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusRepository;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.Candidate;
import ru.tsystems.tchallenge.service.kernel.domain.person.Person;
import ru.tsystems.tchallenge.service.kernel.generic.GenericService;
import ru.tsystems.tchallenge.service.kernel.utility.encryption.EncryptionService;

@CommonService
public class AccountService extends GenericService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRealmRepository realmRepository;

    @Autowired
    private AccountStatusRepository statusRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private EncryptionService encryptionService;

    public AccountInfo create(final AccountInvoice invoice) {
        final Account account = new Account();
        account.setEmail(invoice.getEmail());
        account.setLogin(invoice.getLogin());
        account.setRealm(realmRepository.findById(invoice.getRealm()));
        account.setStatus(statusRepository.findById("CREATED"));
        account.setSecretHash(encryptionService.accountSecretHash(invoice.getSecret()));
        switch (invoice.getRealm()) {
            case "CANDIDATE":
                final Person person = new Person();
                person.setQuickname(invoice.getPerson().getQuickname());
                account.setPerson(person);
                final Candidate candidate = new Candidate();
                account.setCandidate(candidate);
                break;
            case "EMPLOYEE":
                break;
            default:
                break;
        }
        return accountMapper.info(accountRepository.save(account));
    }
}
