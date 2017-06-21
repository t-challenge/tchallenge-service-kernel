package ru.tchallenge.service.kernel.validation.access;

public final class TokenDeactivatedViolationInfo extends TokenViolationInfo {

    public TokenDeactivatedViolationInfo(final String payload) {
        super(payload);
    }

    @Override
    public String getDescription() {
        return String.format("token (%s) has been deactivated due to absence of activity", getPayload());
    }

    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".DEACTIVATED");
    }
}
