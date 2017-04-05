package ru.tsystems.tchallenge.service.kernel.validation.resource;

public class ResourceUnknownViolationInfo extends ResourceViolationInfo {

    private final String path;

    public ResourceUnknownViolationInfo(final String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String getDescription() {
        return "the requested resource is unknown";
    }

    @Override
    protected StringBuilder assembleTextcode() {
        return super.assembleTextcode().append(".UNKNOWN");
    }
}
