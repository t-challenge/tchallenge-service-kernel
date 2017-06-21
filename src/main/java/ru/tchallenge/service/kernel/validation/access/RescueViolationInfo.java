package ru.tchallenge.service.kernel.validation.access;

public abstract class RescueViolationInfo extends AccessViolationInfo {

    private final String payload;

    public RescueViolationInfo(final String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".RESCUE");
    }
}
