package ru.tsystems.tchallenge.service.kernel.domain.account.claim;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.FacadeService;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.security.credential.EmailCredentialInvoice;
import ru.tsystems.tchallenge.service.kernel.security.token.TokenFacade;
import ru.tsystems.tchallenge.service.kernel.validation.ValidationInfo;

@FacadeService
public class AccountClaimFacadeBean extends GenericFacade implements AccountClaimFacade {

    private final AccountService accountService;
    private final AccountClaimMapper accountClaimMapper;
    private final AccountClaimValidator accountClaimValidator;
    private final TokenFacade tokenFacade;

    @Autowired
    public AccountClaimFacadeBean(final AccountService accountService,
                                  final AccountClaimMapper accountClaimMapper,
                                  final AccountClaimValidator accountClaimValidator,
                                  final TokenFacade tokenFacade) {
        this.accountService = accountService;
        this.accountClaimMapper = accountClaimMapper;
        this.accountClaimValidator = accountClaimValidator;
        this.tokenFacade = tokenFacade;
    }

    @Override
    public AccountClaimInfo create(final AccountClaimInvoice invoice) {
        accountClaimValidator.ensure(invoice);
        final AccountInvoice accountInvoice = accountClaimMapper.accountInvoice(invoice);
        final AccountInfo accountInfo = accountService.create(accountInvoice);
        if (invoice.getRealm().equals("CANDIDATE")) {
            final AccountInvoice updateInvoice = new AccountInvoice();
            updateInvoice.setLoginExisting(accountInfo.getLogin());
            updateInvoice.setStatus("APPROVED");
            updateInvoice.setUpdatedProperties(Arrays.asList("status"));
            accountService.update(updateInvoice);
        }
        final EmailCredentialInvoice credentialInvoice = new EmailCredentialInvoice();
        credentialInvoice.setFlashback(invoice.getFlashback());
        credentialInvoice.setEmail(accountInfo.getEmail());
        tokenFacade.createAndMail(credentialInvoice);
        return accountClaimMapper.info(accountInfo);
    }

    @Override
    public ValidationInfo validate(final AccountClaimInvoice invoice) {
        return accountClaimValidator.validate(invoice);
    }
}
