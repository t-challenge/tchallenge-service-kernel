package ru.tchallenge.service.kernel.domain.account.claim;

import ru.tchallenge.service.kernel.conventions.components.ValidatorService;
import ru.tchallenge.service.kernel.generic.GenericValidator;
import ru.tchallenge.service.kernel.validation.ValidationInfo;

@ValidatorService
public class AccountClaimValidatorBean extends GenericValidator implements AccountClaimValidator {

    @Override
    public AccountClaimInvoice ensure(final AccountClaimInvoice invoice) {
        return ensure(invoice, this::validate);
    }

    @Override
    public ValidationInfo validate(final AccountClaimInvoice invoice) {
        return new ValidationInfo(true);
    }
}
