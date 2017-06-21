package ru.tchallenge.service.kernel.validation.access;

public final class IllegalAccountStatusViolationInfo extends AccountAccessViolationInfo {

    private final String status;

    public IllegalAccountStatusViolationInfo(final String login,
                                             final String status) {
        super(login);
        this.status = status;
    }

    @Override
    public String getDescription() {
        return String.format("account status (%s) is illegal for logon", status);
    }

    public String getStatus() {
        return status;
    }

    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".STATUS");
    }
}
