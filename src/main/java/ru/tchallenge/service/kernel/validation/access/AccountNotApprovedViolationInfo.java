package ru.tchallenge.service.kernel.validation.access;

public final class AccountNotApprovedViolationInfo extends AccountStatusViolationInfo {

    public AccountNotApprovedViolationInfo(final String status) {
        super(status);
    }

    @Override
    public String getDescription() {
        return "the account has not been approved by administrator yet";
    }
}
