package ru.tchallenge.service.kernel.validation.access;

public interface AccessValidationExceptionEmitter {

    void accountBlocked(final String status);

    void accountNotApproved(final String status);

    void accountSuspended(final String status);

    void illegalCredential();

    void illegalToken();

    void unauthenticated();

    void unauthorized();

    void tokenDeactivated();
}
