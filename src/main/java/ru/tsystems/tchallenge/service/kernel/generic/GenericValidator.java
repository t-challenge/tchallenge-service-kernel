package ru.tsystems.tchallenge.service.kernel.generic;

import java.util.Collection;
import java.util.function.Function;

import ru.tsystems.tchallenge.service.kernel.validation.contract.ContractValidationException;
import ru.tsystems.tchallenge.service.kernel.validation.contract.ContractViolationInfo;

public abstract class GenericValidator extends GenericService {

    protected <T> T ensure(final T sample,
                           final Function<T, Collection<? extends ContractViolationInfo>> validator) {
        final Collection<? extends ContractViolationInfo> violations = validator.apply(sample);
        if (violations.size() > 0) {
            throw new ContractValidationException(violations);
        }
        return sample;
    }
}
