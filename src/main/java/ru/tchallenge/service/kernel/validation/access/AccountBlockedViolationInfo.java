package ru.tchallenge.service.kernel.validation.access;

public final class AccountBlockedViolationInfo extends AccountStatusViolationInfo {

    public AccountBlockedViolationInfo(final String status) {
        super(status);
    }

    @Override
    public String getDescription() {
        return "the account has been blocked";
    }
}
