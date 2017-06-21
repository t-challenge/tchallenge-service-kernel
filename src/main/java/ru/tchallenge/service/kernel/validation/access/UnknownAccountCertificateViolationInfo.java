package ru.tchallenge.service.kernel.validation.access;

public final class UnknownAccountCertificateViolationInfo extends AccountCertificateAccessViolationInfo {

    public UnknownAccountCertificateViolationInfo(final String payload) {
        super(payload);
    }

    @Override
    public String getDescription() {
        return String.format("account certificate (%s) has not been recognized", getPayload());
    }

    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".UNKNOWN");
    }
}
