package ru.tsystems.tchallenge.service.kernel.validation.contract;

import ru.tsystems.tchallenge.service.kernel.validation.ViolationInfo;

public abstract class ContractViolationInfo extends ViolationInfo {

    private final String name;
    private final Object value;
    private final String constraint;

    public ContractViolationInfo(final String name,
                                 final Object value,
                                 final String constraint) {
        this.name = name;
        this.value = value;
        this.constraint = constraint;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public String getConstraint() {
        return constraint;
    }

    @Override
    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".VALIDATION");
    }
}
