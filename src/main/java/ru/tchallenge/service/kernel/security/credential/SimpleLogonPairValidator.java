package ru.tchallenge.service.kernel.security.credential;

import java.util.Collection;

import ru.tchallenge.service.kernel.validation.contract.ContractViolationInfo;

public interface SimpleLogonPairValidator {

    SimpleLogonPairInvoice ensure(SimpleLogonPairInvoice pair);

    Collection<? extends ContractViolationInfo> validate(SimpleLogonPairInvoice pair);
}
