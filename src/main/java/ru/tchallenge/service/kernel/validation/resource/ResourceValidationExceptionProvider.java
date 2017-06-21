package ru.tchallenge.service.kernel.validation.resource;

import java.util.Collection;

import ru.tchallenge.service.kernel.validation.ValidationException;
import ru.tchallenge.service.kernel.validation.contract.ContractViolationInfo;

public interface ResourceValidationExceptionProvider {

    ValidationException exception(ResourceViolationInfo... violations);

    ValidationException exception(Collection<ResourceViolationInfo> violations);
}
