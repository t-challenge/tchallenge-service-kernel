package ru.tsystems.tchallenge.service.kernel.validation.access;

public final class AccountSuspendedViolationInfo extends AccountStatusViolationInfo {

    public AccountSuspendedViolationInfo(final String status) {
        super(status);
    }

    @Override
    public String getDescription() {
        return "the account has been suspended";
    }
}
