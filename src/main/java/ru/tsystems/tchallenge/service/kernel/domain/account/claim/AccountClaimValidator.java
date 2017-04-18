package ru.tsystems.tchallenge.service.kernel.domain.account.claim;

import ru.tsystems.tchallenge.service.kernel.validation.ValidationInfo;

public interface AccountClaimValidator {

    AccountClaimInvoice ensure(AccountClaimInvoice invoice);

    ValidationInfo validate(AccountClaimInvoice invoice);
}
