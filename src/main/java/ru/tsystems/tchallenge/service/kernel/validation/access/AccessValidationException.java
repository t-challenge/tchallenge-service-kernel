package ru.tsystems.tchallenge.service.kernel.validation.access;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.validation.ValidationException;
import ru.tsystems.tchallenge.service.kernel.validation.ValidationExceptionCategory;
import ru.tsystems.tchallenge.service.kernel.validation.ViolationInfo;

public class AccessValidationException extends ValidationException {

    public AccessValidationException(final Collection<? extends ViolationInfo> violations) {
        super(violations);
    }

    @Override
    public ValidationExceptionCategory getCategory() {
        return ValidationExceptionCategory.ACCESS;
    }
}
