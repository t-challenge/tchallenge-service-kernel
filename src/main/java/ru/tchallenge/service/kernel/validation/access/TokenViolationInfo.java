package ru.tchallenge.service.kernel.validation.access;

public abstract class TokenViolationInfo extends AccessViolationInfo {

    private final String payload;

    public TokenViolationInfo(final String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".TOKEN");
    }
}
