package ru.tsystems.tchallenge.service.kernel.validation.resource;

import java.util.ArrayList;
import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.validation.ViolationInfo;

public class ResourceValidationExceptionEmitter {

    public static void resourceUnavailable(final String name, final String identifier) {
        exception(new ResourceUnavailableViolationInfo(name, identifier));
    }

    public static void resourceUnknown(final String path) {
        exception(new ResourceUnknownViolationInfo(path));
    }

    private static void exception(final ViolationInfo violation) {
        final Collection<ViolationInfo> violations = new ArrayList<>();
        violations.add(violation);
        throw new ResourceValidationException(violations);
    }

    private ResourceValidationExceptionEmitter() {

    }
}
