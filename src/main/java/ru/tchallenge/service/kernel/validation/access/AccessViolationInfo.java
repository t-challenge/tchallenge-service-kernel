package ru.tchallenge.service.kernel.validation.access;

import ru.tchallenge.service.kernel.validation.ViolationInfo;

public abstract class AccessViolationInfo extends ViolationInfo {

    @Override
    protected StringBuilder assembleTextcode() {
        return super
                .assembleTextcode()
                .append(".ACCESS");
    }
}
