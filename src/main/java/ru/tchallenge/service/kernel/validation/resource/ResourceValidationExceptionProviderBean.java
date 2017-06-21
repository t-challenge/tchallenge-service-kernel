package ru.tchallenge.service.kernel.validation.resource;

import java.util.Arrays;
import java.util.Collection;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericService;
import ru.tchallenge.service.kernel.validation.ValidationException;
import ru.tchallenge.service.kernel.validation.ValidationExceptionCategory;
import ru.tchallenge.service.kernel.validation.contract.ContractViolationInfo;

@ServiceComponent
public class ResourceValidationExceptionProviderBean extends GenericService implements ResourceValidationExceptionProvider {

    @Override
    public ValidationException exception(final ResourceViolationInfo... violations) {
        return exception(Arrays.asList(violations));
    }

    @Override
    public ValidationException exception(final Collection<ResourceViolationInfo> violations) {
        return new ValidationException(ValidationExceptionCategory.RESOURCE, violations);
    }
}
