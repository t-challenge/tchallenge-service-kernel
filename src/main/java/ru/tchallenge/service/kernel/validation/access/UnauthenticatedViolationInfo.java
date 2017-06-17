package ru.tchallenge.service.kernel.validation.access;

public final class UnauthenticatedViolationInfo extends AccessViolationInfo {

    @Override
    public String getDescription() {
        return "authentication required";
    }

    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".UNAUTHENTICATED");
    }
}
