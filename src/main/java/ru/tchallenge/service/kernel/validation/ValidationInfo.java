package ru.tchallenge.service.kernel.validation;

import java.util.ArrayList;
import java.util.Collection;

import com.google.common.collect.ImmutableList;

import ru.tchallenge.service.kernel.generic.GenericInfo;

public final class ValidationInfo extends GenericInfo {

    public static final class Builder {

        private final Collection<ViolationInfo> violations = new ArrayList<>();

        public ValidationInfo build() {
            return new ValidationInfo(this);
        }

        public Builder addViolation(final ViolationInfo violation) {
            violations.add(violation);
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private final Collection<ViolationInfo> violations;

    public ValidationInfo(final Collection<ViolationInfo> violations) {
        this.violations = ImmutableList.copyOf(violations);
    }

    private ValidationInfo(final Builder builder) {
        this.violations = ImmutableList.copyOf(builder.violations);
    }

    public Boolean getValid() {
        return violations.isEmpty();
    }

    public Collection<ViolationInfo> getViolations() {
        return violations;
    }
}
