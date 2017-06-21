package ru.tchallenge.service.kernel.validation.access;

public final class IllegalAccountCertificateStatusViolationInfo extends AccountCertificateAccessViolationInfo {

    private final String status;

    public IllegalAccountCertificateStatusViolationInfo(final String payload,
                                                        final String status) {
        super(payload);
        this.status = status;
    }

    @Override
    public String getDescription() {
        return String.format("account certificate status (%s) is illegal for logon", status);
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
