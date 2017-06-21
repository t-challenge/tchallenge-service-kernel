package ru.tchallenge.service.kernel.validation.access;

public abstract class AccountCertificateAccessViolationInfo extends AccessViolationInfo {

    private final String payload;

    public AccountCertificateAccessViolationInfo(final String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".CERTIFICATE");
    }
}
