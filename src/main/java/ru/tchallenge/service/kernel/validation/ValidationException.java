package ru.tchallenge.service.kernel.validation;

import java.util.ArrayList;
import java.util.Collection;

import ru.tchallenge.service.kernel.utility.Generators;

public final class ValidationException extends RuntimeException {

    private final String id;
    private final ValidationExceptionCategory category;
    private final Collection<? extends ViolationInfo> violations;

    public ValidationException(final ValidationExceptionCategory category,
                               final Collection<? extends ViolationInfo> violations) {
        this.id = Generators.uuid();
        this.category = category;
        this.violations = new ArrayList<>(violations);
    }

    public String getId() {
        return id;
    }

    public ValidationExceptionCategory getCategory() {
        return category;
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
