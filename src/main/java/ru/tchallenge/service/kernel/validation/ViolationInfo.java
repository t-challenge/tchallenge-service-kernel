package ru.tchallenge.service.kernel.validation;

import ru.tchallenge.service.kernel.generic.GenericInfo;

public abstract class ViolationInfo extends GenericInfo {

    public abstract String getDescription();

    public String getTextcode() {
        return assembleTextcode().toString();
    }

    protected StringBuilder assembleTextcode() {
        return new StringBuilder().append("X");
    }
}
