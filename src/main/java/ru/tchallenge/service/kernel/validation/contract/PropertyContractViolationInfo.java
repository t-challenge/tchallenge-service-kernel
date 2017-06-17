package ru.tchallenge.service.kernel.validation.contract;

public class PropertyContractViolationInfo extends ContractViolationInfo {

    public PropertyContractViolationInfo(final String name,
                                         final Object value,
                                         final String constraint) {
        super(name, value, constraint);
    }

    @Override
    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".PROPERTY");
    }

    @Override
    public String getDescription() {
        return "property value does meet existing constraint";
    }
}
