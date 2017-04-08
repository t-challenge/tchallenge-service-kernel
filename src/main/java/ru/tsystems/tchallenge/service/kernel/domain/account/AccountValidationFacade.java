package ru.tsystems.tchallenge.service.kernel.domain.account;

import ru.tsystems.tchallenge.service.kernel.validation.ValidationInfo;

public interface AccountValidationFacade {

    ValidationInfo validateEmail(AccountInvoice invoice);

    ValidationInfo validateLogin(AccountInvoice invoice);

    ValidationInfo validateSecret(AccountInvoice invoice);

    ValidationInfo validateStatus(AccountInvoice invoice);
}
