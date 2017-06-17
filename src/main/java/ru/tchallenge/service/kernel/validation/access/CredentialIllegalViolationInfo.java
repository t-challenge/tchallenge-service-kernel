package ru.tchallenge.service.kernel.validation.access;

public final class CredentialIllegalViolationInfo extends CredentialViolationInfo {

    @Override
    public String getDescription() {
        return "authentication by the credential has failed";
    }

    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".ILLEGAL");
    }
}
