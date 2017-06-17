package ru.tchallenge.service.kernel.validation.access;

public abstract class AccountStatusViolationInfo extends AccessViolationInfo {

    private final String status;

    public AccountStatusViolationInfo(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".ACCOUNT");
    }
}
