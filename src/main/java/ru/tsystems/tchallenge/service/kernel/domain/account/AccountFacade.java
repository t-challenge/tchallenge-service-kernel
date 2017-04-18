package ru.tsystems.tchallenge.service.kernel.domain.account;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;

@FacadeService
public class AccountFacade extends GenericFacade {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountService accountService;

    public AccountInfo create(final AccountInvoice invoice) {
        // TODO: authorize EMPLOYEE(ADMIN)
        return accountService.create(invoice);
    }

    public AccountInfo get(final String login) {
        // TODO: authorize EMPLOYEE
        throw new UnsupportedOperationException();
    }

    public AccountInfo getAuthenticated() {
        return accountService.getByLogin("ivan.sidorov@some-email.com");
    }

    public SearchInfo<AccountInfo> search(final AccountSearchInvoice invoice) {
        // TODO: authorize EMPLOYEE(ADMIN)
        final SearchInfo<AccountInfo> search = new SearchInfo<>();
        search.setItems(accountRepository.findAll().stream().map(accountMapper::info).collect(Collectors.toList()));
        return search;
    }

    public AccountInfo update(final AccountInvoice invoice) {
        // TODO: authorize AUTHENTICATED, EMPLOYEE(ADMIN)
        throw new UnsupportedOperationException();
    }

    public Object validate(final AccountInvoice invoice) {
        // TODO: authorize AUTHENTICATED
        throw new UnsupportedOperationException();
    }
}
