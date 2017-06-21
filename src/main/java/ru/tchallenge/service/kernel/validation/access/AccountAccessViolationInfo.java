package ru.tchallenge.service.kernel.validation.access;

public abstract class AccountAccessViolationInfo extends AccessViolationInfo {

    private final String login;

    public AccountAccessViolationInfo(final String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    @Override
    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".ACCOUNT");
    }
}
