package ru.tsystems.tchallenge.service.kernel.validation;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public abstract class ViolationInfo extends GenericInfo {

    public ViolationInfo() {

    }

    public abstract String getDescription();

    public String getTextcode() {
        return assembleTextcode().toString();
    }

    protected StringBuilder assembleTextcode() {
        return new StringBuilder().append("X");
    }
}
