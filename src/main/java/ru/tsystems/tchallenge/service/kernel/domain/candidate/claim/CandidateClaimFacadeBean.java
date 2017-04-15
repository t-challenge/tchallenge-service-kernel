package ru.tsystems.tchallenge.service.kernel.domain.candidate.claim;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.domain.account.claim.AccountClaimInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.claim.AccountClaimInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.CandidateInfo;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.CandidateInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.CandidateService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;

@FacadeService
public class CandidateClaimFacadeBean extends GenericFacade implements CandidateClaimFacade {

    @Autowired
    private CandidateService candidateService;

    @Override
    public AccountClaimInfo create(final AccountClaimInvoice invoice) {
        final CandidateInvoice candidateInvoice = new CandidateInvoice();
        candidateInvoice.setEmail(invoice.getEmail());
        candidateInvoice.setLogin(invoice.getEmail());
        candidateInvoice.setSecret("123");
        final CandidateInfo info = candidateService.create(candidateInvoice);
        return new AccountClaimInfo(
                info.getAccount().getLogin(),
                info.getAccount().getCreatedAt());
    }
}
