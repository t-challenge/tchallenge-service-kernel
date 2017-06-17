package ru.tchallenge.service.kernel.validation.resource;

import java.util.Collection;

import ru.tchallenge.service.kernel.validation.ValidationException;
import ru.tchallenge.service.kernel.validation.ValidationExceptionCategory;
import ru.tchallenge.service.kernel.validation.ViolationInfo;

public class ResourceValidationException extends ValidationException {

    public ResourceValidationException(final Collection<? extends ViolationInfo> violations) {
        super(violations);
    }

    @Override
    public ValidationExceptionCategory getCategory() {
        return ValidationExceptionCategory.RESOURCE;
    }
}
