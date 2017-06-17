package ru.tchallenge.service.kernel.validation;

import java.util.ArrayList;
import java.util.Collection;

import ru.tchallenge.service.kernel.utility.Generators;

public abstract class ValidationException extends RuntimeException {

    private final String id;
    private final Collection<? extends ViolationInfo> violations;

    public ValidationException(final Collection<? extends ViolationInfo> violations) {
        this.id = Generators.uuid();
        this.violations = new ArrayList<>(violations);
    }

    public abstract ValidationExceptionCategory getCategory();

    public String getId() {
        return id;
    }

    @Override
    public String getMessage() {
        // TODO: construct message
        return super.getMessage();
    }

    public Collection<? extends ViolationInfo> getViolations() {
        return new ArrayList<>(violations);
    }
}
