package ru.tchallenge.service.kernel.validation.contract;

import java.util.Collection;

import ru.tchallenge.service.kernel.validation.ValidationException;
import ru.tchallenge.service.kernel.validation.ValidationExceptionCategory;
import ru.tchallenge.service.kernel.validation.ViolationInfo;

public class ContractValidationException extends ValidationException {

    public ContractValidationException(final Collection<? extends ViolationInfo> violations) {
        super(violations);
    }

    @Override
    public ValidationExceptionCategory getCategory() {
        return ValidationExceptionCategory.CONTRACT;
    }
}
