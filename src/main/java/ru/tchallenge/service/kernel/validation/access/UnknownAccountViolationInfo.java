package ru.tchallenge.service.kernel.validation.access;

public final class UnknownAccountViolationInfo extends AccountAccessViolationInfo {

    public UnknownAccountViolationInfo(final String login) {
        super(login);
    }

    @Override
    public String getDescription() {
        return String.format("account has not been recognized by login (%s) and password", getLogin());
    }

    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".UNKNOWN");
    }
}
