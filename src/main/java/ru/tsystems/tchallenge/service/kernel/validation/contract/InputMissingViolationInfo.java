package ru.tsystems.tchallenge.service.kernel.validation.contract;

public class InputMissingViolationInfo extends InputContractViolationInfo {

    public InputMissingViolationInfo(final String name) {
        super(name, null, "input object is required");
    }

    @Override
    public String getDescription() {
        return "input object is null";
    }
}
