package ru.tchallenge.service.kernel.validation.contract;

import java.util.Arrays;
import java.util.Collection;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericService;
import ru.tchallenge.service.kernel.validation.ValidationException;
import ru.tchallenge.service.kernel.validation.ValidationExceptionCategory;

@ServiceComponent
public class ContractValidationExceptionProviderBean extends GenericService implements ContractValidationExceptionProvider {

    @Override
    public ValidationException exception(final ContractViolationInfo... violations) {
        return exception(Arrays.asList(violations));
    }

    @Override
    public ValidationException exception(final Collection<ContractViolationInfo> violations) {
        return new ValidationException(ValidationExceptionCategory.CONTRACT, violations);
    }
}
