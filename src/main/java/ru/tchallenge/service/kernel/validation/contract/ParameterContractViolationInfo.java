package ru.tchallenge.service.kernel.validation.contract;

public class ParameterContractViolationInfo extends ContractViolationInfo {

    public ParameterContractViolationInfo(final String name,
                                          final Object value,
                                          final String constraint) {
        super(name, value, constraint);
    }

    @Override
    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".PARAMETER");
    }

    @Override
    public String getDescription() {
        return "parameter value does meet existing constraint";
    }
}
