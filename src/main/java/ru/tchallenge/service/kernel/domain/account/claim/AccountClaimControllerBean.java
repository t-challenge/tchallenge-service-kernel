package ru.tchallenge.service.kernel.domain.account.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tchallenge.service.kernel.generic.GenericController;
import ru.tchallenge.service.kernel.validation.ValidationInfo;

@RestController
@RequestMapping(path = "/data/accounts/claims")
public class AccountClaimControllerBean extends GenericController {

    private final AccountClaimFacade accountClaimFacade;

    @Autowired
    public AccountClaimControllerBean(final AccountClaimFacade accountClaimFacade) {
        this.accountClaimFacade = accountClaimFacade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public AccountClaimInfo create(@RequestBody final AccountClaimInvoice invoice) {
        return accountClaimFacade.create(invoice);
    }

    @RequestMapping(path = "/validation", method = RequestMethod.POST)
    public ValidationInfo validate(@RequestBody final AccountClaimInvoice invoice) {
        return accountClaimFacade.validate(invoice);
    }
}
