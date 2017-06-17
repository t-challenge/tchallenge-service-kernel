package ru.tchallenge.service.kernel.reliability;

import java.util.ArrayList;
import java.util.Collection;

import ru.tchallenge.service.kernel.generic.GenericInfo;
import ru.tchallenge.service.kernel.validation.ViolationInfo;

public final class ExceptionInfo extends GenericInfo {

    private final String id;
    private final String description;
    private final String textcode;
    private final Collection<? extends ViolationInfo> violations;

    public ExceptionInfo(final String id,
                         final String description,
                         final String textcode,
                         final Collection<? extends ViolationInfo> violations) {
        this.id = id;
        this.description = description;
        this.textcode = textcode;
        this.violations = new ArrayList<>(violations);
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTextcode() {
        return textcode;
    }

    public Collection<? extends ViolationInfo> getViolations() {
        return violations;
    }
}
