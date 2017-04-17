package ru.tsystems.tchallenge.service.kernel.domain.account.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;

@RestController
@RequestMapping(path = "/data/accounts/claims")
public class AccountClaimControllerBean extends GenericController {

    @Autowired
    private AccountClaimFacade claimFacade;

    @RequestMapping(method = RequestMethod.POST)
    public AccountClaimInfo create(@RequestBody final AccountClaimInvoice invoice) {
        return claimFacade.create(invoice);
    }

    @RequestMapping(path = "/validation", method = RequestMethod.POST)
    public Object validate(@RequestBody final AccountClaimInvoice invoice) {
        return claimFacade.validate(invoice);
    }
}
