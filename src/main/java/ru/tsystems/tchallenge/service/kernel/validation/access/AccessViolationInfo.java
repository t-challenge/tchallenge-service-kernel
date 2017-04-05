package ru.tsystems.tchallenge.service.kernel.validation.access;

import ru.tsystems.tchallenge.service.kernel.validation.ViolationInfo;

public abstract class AccessViolationInfo extends ViolationInfo {

    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".ACCESS");
    }
}
