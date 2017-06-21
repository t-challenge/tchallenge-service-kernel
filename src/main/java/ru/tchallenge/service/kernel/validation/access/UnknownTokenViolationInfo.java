package ru.tchallenge.service.kernel.validation.access;

public final class UnknownTokenViolationInfo extends TokenViolationInfo {

    public UnknownTokenViolationInfo(final String payload) {
        super(payload);
    }

    @Override
    public String getDescription() {
        return String.format("token %s has not been recognized", getPayload());
    }

    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".UNKNOWN");
    }
}
