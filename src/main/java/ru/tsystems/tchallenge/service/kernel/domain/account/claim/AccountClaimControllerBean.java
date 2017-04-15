package ru.tsystems.tchallenge.service.kernel.domain.account.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.domain.candidate.claim.CandidateClaimFacade;
import ru.tsystems.tchallenge.service.kernel.generic.GenericController;

@RestController
@RequestMapping(path = "/data/accounts/claims")
public final class AccountClaimControllerBean extends GenericController {

    private final CandidateClaimFacade candidateClaimFacade;

    @Autowired
    public AccountClaimControllerBean(final CandidateClaimFacade candidateClaimFacade) {
        this.candidateClaimFacade = candidateClaimFacade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object create(@RequestBody final AccountClaimInvoice invoice) {
        return claimFacade(invoice.getRealm()).create(invoice);
    }

    private AccountClaimFacade claimFacade(final String realm) {
        switch (realm) {
            case "CANDIDATE":
                return candidateClaimFacade;
            default:
                throw new UnsupportedOperationException("REALM NOT SUPPORTED");
        }
    }
}
