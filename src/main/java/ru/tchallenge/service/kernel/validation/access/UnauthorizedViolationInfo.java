package ru.tchallenge.service.kernel.validation.access;

public final class UnauthorizedViolationInfo extends AccessViolationInfo {

    @Override
    public String getDescription() {
        return "the request cannot be fulfilled due to lack of permissions";
    }

    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".UNAUTHORIZED");
    }
}
