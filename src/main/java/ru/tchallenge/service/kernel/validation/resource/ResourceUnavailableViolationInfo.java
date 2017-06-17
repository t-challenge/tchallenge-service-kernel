package ru.tchallenge.service.kernel.validation.resource;

public final class ResourceUnavailableViolationInfo extends ResourceViolationInfo {

    private final String name;
    private final String identifier;

    public ResourceUnavailableViolationInfo(final String name,
                                            final String identifier) {
        this.name = name;
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getDescription() {
        return "the requested resource is unavailable";
    }

    @Override
    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".UNAVAILABLE");
    }
}
