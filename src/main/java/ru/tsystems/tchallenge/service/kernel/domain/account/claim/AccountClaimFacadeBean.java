package ru.tsystems.tchallenge.service.kernel.domain.account.claim;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.validation.ValidationInfo;

@FacadeService
public class AccountClaimFacadeBean extends GenericFacade implements AccountClaimFacade {

    private final AccountService accountService;
    private final AccountClaimMapper accountClaimMapper;
    private final AccountClaimValidator accountClaimValidator;

    @Autowired
    public AccountClaimFacadeBean(final AccountService accountService,
                                  final AccountClaimMapper accountClaimMapper,
                                  final AccountClaimValidator accountClaimValidator) {
        this.accountService = accountService;
        this.accountClaimMapper = accountClaimMapper;
        this.accountClaimValidator = accountClaimValidator;
    }

    @Override
    public AccountClaimInfo create(final AccountClaimInvoice invoice) {
        accountClaimValidator.ensure(invoice);
        final AccountInvoice accountInvoice = accountClaimMapper.accountInvoice(invoice);
        final AccountInfo accountInfo = accountService.create(accountInvoice);
        return accountClaimMapper.info(accountInfo);
    }

    @Override
    public ValidationInfo validate(final AccountClaimInvoice invoice) {
        return accountClaimValidator.validate(invoice);
    }
}
