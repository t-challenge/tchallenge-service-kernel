package ru.tsystems.tchallenge.service.kernel.validation.access;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.shared.GenericService;

@Service
public class AccessValidationExceptionEmitterBean extends GenericService implements AccessValidationExceptionEmitter {

    public void accountBlocked(final String status) {
        accessException(new AccountBlockedViolationInfo(status));
    }

    public void accountNotApproved(final String status) {
        accessException(new AccountNotApprovedViolationInfo(status));
    }

    public void accountSuspended(final String status) {
        accessException(new AccountSuspendedViolationInfo(status));
    }

    public void illegalCredential() {
        accessException(new CredentialIllegalViolationInfo());
    }

    public void illegalToken() {
        accessException(new TokenIllegalViolationInfo());
    }

    public void unauthenticated() {
        accessException(new UnauthenticatedViolationInfo());
    }

    public void unauthorized() {
        accessException(new UnauthorizedViolationInfo());
    }

    public void tokenDeactivated() {
        accessException(new TokenDeactivatedViolationInfo());
    }

    private void accessException(final AccessViolationInfo violation) {
        final Collection<AccessViolationInfo> violations = new ArrayList<>();
        violations.add(violation);
        throw new AccessValidationException(violations);
    }
}
