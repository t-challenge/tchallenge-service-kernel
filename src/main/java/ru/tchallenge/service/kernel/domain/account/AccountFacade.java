package ru.tchallenge.service.kernel.domain.account;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.FacadeService;
import ru.tchallenge.service.kernel.domain.candidate.Candidate;
import ru.tchallenge.service.kernel.domain.person.Person;
import ru.tchallenge.service.kernel.generic.GenericFacade;
import ru.tchallenge.service.kernel.generic.page.SearchInfo;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

@FacadeService
public class AccountFacade extends GenericFacade {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    public AccountInfo create(final AccountInvoice invoice) {
        // TODO: authorize EMPLOYEE(ADMIN)
        return accountService.create(invoice);
    }

    public AccountInfo get(final String login) {
        // TODO: authorize EMPLOYEE
        throw new UnsupportedOperationException();
    }

    public AccountInfo getAuthenticated() {
        final AuthenticationInfo authentication = getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final String login = authentication.getAccount().getLogin();
        return accountService.getByLogin(login);
    }

    public SearchInfo<AccountInfo> search(final AccountSearchInvoice invoice) {
        // TODO: authorize EMPLOYEE(ADMIN)
        final SearchInfo<AccountInfo> search = new SearchInfo<>();
        search.setItems(accountRepository.findAll().stream().map(accountMapper::info).collect(Collectors.toList()));
        return search;
    }

    public AccountInfo update(final AccountInvoice invoice) {
        final AuthenticationInfo authentication = this.getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final AccountInfo accountInfo = authentication.getAccount();
        if (!accountInfo.getLogin().equals(invoice.getLoginExisting())) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final Account account = accountRepository.findByLogin(accountInfo.getLogin());
        if (invoice.getCandidate() != null) {
            if (account.getCandidate() == null) {
                account.setCandidate(new Candidate());
            }
            account.getCandidate().setInterested(invoice.getCandidate().getInterested() != null ? invoice.getCandidate().getInterested() ? 1 : 0 : 0);
            account.getCandidate().setSelfie(invoice.getCandidate().getSelfie());
            account.getCandidate().setGithub(invoice.getCandidate().getGithub());
            account.getCandidate().setCv(invoice.getCandidate().getCv());
        }
        if (invoice.getPerson() != null) {
            if (account.getPerson() == null) {
                account.setPerson(new Person());
            }
            account.getPerson().setFirstname(invoice.getPerson().getFirstname());
            account.getPerson().setLastname(invoice.getPerson().getLastname());
            account.getPerson().setQuickname(invoice.getPerson().getQuickname());
        }
        accountRepository.save(account);
        return accountMapper.info(account);
    }

    public Object validate(final AccountInvoice invoice) {
        // TODO: authorize AUTHENTICATED
        throw new UnsupportedOperationException();
    }
}
