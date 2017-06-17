package ru.tchallenge.service.kernel.validation.resource;

import ru.tchallenge.service.kernel.validation.ViolationInfo;

public abstract class ResourceViolationInfo extends ViolationInfo {

    @Override
    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".RESOURCE");
    }
}
