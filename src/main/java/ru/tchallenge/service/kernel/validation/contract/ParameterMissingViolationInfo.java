package ru.tchallenge.service.kernel.validation.contract;

public class ParameterMissingViolationInfo extends PropertyContractViolationInfo {

    public ParameterMissingViolationInfo(final String name) {
        super(name, null, "parameter is required");
    }
}
