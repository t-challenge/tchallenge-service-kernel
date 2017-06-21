package ru.tchallenge.service.kernel.validation.access;

import ru.tchallenge.service.kernel.validation.ValidationException;

public interface AccessValidationExceptionProvider {

    ValidationException illegalAccountStatus(final String login, final String status);

    ValidationException illegalAccountCertificateStatus(final String payload, final String status);

    ValidationException rescueExpired(final String payload);

    ValidationException tokenDeactivated(final String payload);

    ValidationException unauthenticated();

    ValidationException unauthorized();

    ValidationException unknownAccount(final String login);

    ValidationException unknownAccountCertificate(final String payload);

    ValidationException unknownRescue(final String payload);

    ValidationException unknownToken(final String payload);
}
