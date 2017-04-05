package ru.tsystems.tchallenge.service.kernel.validation.access;

public abstract class TokenViolationInfo extends AccessViolationInfo {

    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".TOKEN");
    }
}
