package ru.tchallenge.service.kernel.validation;

public enum ValidationExceptionCategory {

    ACCESS("X.ACCESS", "access control validation"),

    CONTRACT("X.CONTRACT", "data contract validation"),

    RESOURCE("X.RESOURCE", "resource availability validation");

    private final static String PREFIX = "the request cannot be fulfilled due to ";

    private final String textcode;
    private final String description;

    ValidationExceptionCategory(final String textcode, final String descriptionSuffix) {
        this.textcode = textcode;
        this.description = String.format("%s%s", PREFIX, descriptionSuffix);
    }

    public String getTextcode() {
        return textcode;
    }

    public String getDescription() {
        return description;
    }
}
