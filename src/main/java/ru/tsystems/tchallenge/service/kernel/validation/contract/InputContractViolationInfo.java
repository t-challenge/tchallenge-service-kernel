package ru.tsystems.tchallenge.service.kernel.validation.contract;

public abstract class InputContractViolationInfo extends ContractViolationInfo {

    public InputContractViolationInfo(final String name,
                                      final Object value,
                                      final String constraint) {
        super(name, value, constraint);
    }

    @Override
    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".INPUT");
    }
}
