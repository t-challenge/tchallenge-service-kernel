package ru.tchallenge.service.kernel.validation.resource;

public class ResourceExistingViolationInfo extends ResourceViolationInfo {

    private final String name;
    private final String identifier;
    private final String identifierValue;

    public ResourceExistingViolationInfo(final String name,
                                         final String identifier,
                                         final String identifierValue) {
        this.name = name;
        this.identifier = identifier;
        this.identifierValue = identifierValue;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getIdentifierValue() {
        return identifierValue;
    }

    @Override
    public String getDescription() {
        return "the resource already exists";
    }

    @Override
    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".EXISTING");
    }
}
