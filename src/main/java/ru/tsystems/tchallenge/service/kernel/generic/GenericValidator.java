package ru.tsystems.tchallenge.service.kernel.generic;

import java.util.Collection;
import java.util.function.Function;

import ru.tsystems.tchallenge.service.kernel.validation.ValidationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.ViolationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.contract.ContractValidationException;

public abstract class GenericValidator extends GenericService {
/*
    protected <T> T ensure(final T sample,
                           final Function<T, Collection<? extends ViolationInfo>> validator) {
        final Collection<? extends ViolationInfo> violations = validator.apply(sample);
        if (violations.size() > 0) {
            throw new ContractValidationException(violations);
        }
        return sample;
    }
*/
    protected <T> T ensure(final T sample,
                           final Function<T, ValidationInfo> validator) {
        final ValidationInfo info = validator.apply(sample);
        if (!info.getValid()) {
            throw new RuntimeException();
        }
        return sample;
    }
}
