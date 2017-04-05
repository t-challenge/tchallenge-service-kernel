package ru.tsystems.tchallenge.service.kernel.validation.access;

public final class TokenIllegalViolationInfo extends TokenViolationInfo {

    @Override
    public String getDescription() {
        return "authentication by the token has failed";
    }

    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".ILLEGAL");
    }
}
