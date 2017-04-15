package ru.tsystems.tchallenge.service.kernel.domain.account.claim;

public interface AccountClaimFacade {

    AccountClaimInfo create(AccountClaimInvoice invoice);
}
