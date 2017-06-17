package ru.tchallenge.service.kernel.domain.account.claim;

import ru.tchallenge.service.kernel.validation.ValidationInfo;

public interface AccountClaimValidator {

    AccountClaimInvoice ensure(AccountClaimInvoice invoice);

    ValidationInfo validate(AccountClaimInvoice invoice);
}
