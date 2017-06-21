package ru.tchallenge.service.kernel.domain.account.claim;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.FacadeServiceComponent;
import ru.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tchallenge.service.kernel.domain.account.AccountInvoice;
import ru.tchallenge.service.kernel.domain.account.AccountService;
import ru.tchallenge.service.kernel.generic.GenericFacade;
import ru.tchallenge.service.kernel.security.token.TokenService;
import ru.tchallenge.service.kernel.validation.ValidationInfo;

@FacadeServiceComponent
public class AccountClaimFacadeBean extends GenericFacade implements AccountClaimFacade {

    private final AccountService accountService;
    private final AccountClaimMapper accountClaimMapper;
    private final AccountClaimValidator accountClaimValidator;
    private final TokenService tokenService;

    @Autowired
    public AccountClaimFacadeBean(final AccountService accountService,
                                  final AccountClaimMapper accountClaimMapper,
                                  final AccountClaimValidator accountClaimValidator,
                                  final TokenService tokenService) {
        this.accountService = accountService;
        this.accountClaimMapper = accountClaimMapper;
        this.accountClaimValidator = accountClaimValidator;
        this.tokenService = tokenService;
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
        /*
        final EmailCredentialInvoice credentialInvoice = new EmailCredentialInvoice();
        credentialInvoice.setFlashback(invoice.getFlashback());
        credentialInvoice.setEmail(accountInfo.getEmail());
        tokenFacade.createAndMail(credentialInvoice);
        */
        return accountClaimMapper.info(accountInfo);
    }

    @Override
    public ValidationInfo validate(final AccountClaimInvoice invoice) {
        return accountClaimValidator.validate(invoice);
    }
}
