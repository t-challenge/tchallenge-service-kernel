package ru.tchallenge.service.kernel.validation.contract;

import java.util.Collection;

import ru.tchallenge.service.kernel.validation.ValidationException;

public interface ContractValidationExceptionProvider {

    ValidationException exception(ContractViolationInfo... violations);

    ValidationException exception(Collection<ContractViolationInfo> violations);
}
