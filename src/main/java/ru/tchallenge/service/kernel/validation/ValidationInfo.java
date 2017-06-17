package ru.tchallenge.service.kernel.validation;

public final class ValidationInfo {

    private final Boolean valid;

    public ValidationInfo(final Boolean valid) {
        this.valid = valid;
    }

    public Boolean getValid() {
        return valid;
    }
}
