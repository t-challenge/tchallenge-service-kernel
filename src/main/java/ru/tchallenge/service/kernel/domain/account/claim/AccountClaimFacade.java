package ru.tchallenge.service.kernel.domain.account.claim;

import ru.tchallenge.service.kernel.validation.ValidationInfo;

public interface AccountClaimFacade {

    AccountClaimInfo create(AccountClaimInvoice invoice);

    ValidationInfo validate(AccountClaimInvoice invoice);
}
