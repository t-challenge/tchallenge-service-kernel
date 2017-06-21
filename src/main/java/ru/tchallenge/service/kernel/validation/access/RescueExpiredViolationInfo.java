package ru.tchallenge.service.kernel.validation.access;

public final class RescueExpiredViolationInfo extends RescueViolationInfo {

    public RescueExpiredViolationInfo(final String payload) {
        super(payload);
    }

    @Override
    public String getDescription() {
        return String.format("rescue (%s) has been expired", getPayload());
    }

    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".EXPIRED");
    }
}
