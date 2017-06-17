package ru.tchallenge.service.kernel.validation.access;

public final class TokenDeactivatedViolationInfo extends TokenViolationInfo {

    @Override
    public String getDescription() {
        return "the token has been deactivated due to absence of activity";
    }

    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".DEACTIVATED");
    }
}
