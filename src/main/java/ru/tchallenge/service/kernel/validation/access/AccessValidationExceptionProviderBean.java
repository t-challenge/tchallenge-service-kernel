package ru.tchallenge.service.kernel.validation.access;

import java.util.Arrays;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericService;
import ru.tchallenge.service.kernel.validation.ValidationException;
import ru.tchallenge.service.kernel.validation.ValidationExceptionCategory;

@ServiceComponent
public class AccessValidationExceptionProviderBean extends GenericService implements AccessValidationExceptionProvider {

    @Override
    public ValidationException illegalAccountStatus(final String login, final String status) {
        return accessException(new IllegalAccountStatusViolationInfo(login, status));
    }

    @Override
    public ValidationException illegalAccountCertificateStatus(final String payload, final String status) {
        return accessException(new IllegalAccountCertificateStatusViolationInfo(payload, status));
    }

    @Override
    public ValidationException rescueExpired(final String payload) {
        return accessException(new RescueExpiredViolationInfo(payload));
    }

    @Override
    public ValidationException tokenDeactivated(final String payload) {
        return accessException(new TokenDeactivatedViolationInfo(payload));
    }

    @Override
    public ValidationException unauthenticated() {
        return accessException(new UnauthenticatedViolationInfo());
    }

    @Override
    public ValidationException unauthorized() {
        return accessException(new UnauthorizedViolationInfo());
    }

    @Override
    public ValidationException unknownAccount(final String login) {
        return accessException(new UnknownAccountViolationInfo(login));
    }

    @Override
    public ValidationException unknownAccountCertificate(final String payload) {
        return accessException(new UnknownAccountCertificateViolationInfo(payload));
    }

    @Override
    public ValidationException unknownRescue(final String payload) {
        return accessException(new UnknownRescueViolationInfo(payload));
    }

    @Override
    public ValidationException unknownToken(final String payload) {
        return accessException(new UnknownTokenViolationInfo(payload));
    }

    private ValidationException accessException(final AccessViolationInfo... violations) {
        return new ValidationException(ValidationExceptionCategory.ACCESS, Arrays.asList(violations));
    }
}
