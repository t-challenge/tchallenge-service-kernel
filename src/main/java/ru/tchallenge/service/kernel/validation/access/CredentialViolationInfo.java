package ru.tchallenge.service.kernel.validation.access;

public abstract class CredentialViolationInfo extends AccessViolationInfo {

    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".CREDENTIAL");
    }
}
