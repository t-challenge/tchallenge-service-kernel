package ru.tsystems.tchallenge.service.kernel.validation.contract;

public class PropertyMissingViolationInfo extends PropertyContractViolationInfo {

    public PropertyMissingViolationInfo(final String name) {
        super(name, null, "property is required");
    }
}
