package ru.tsystems.tchallenge.service.kernel.security.credential;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.generic.GenericValidator;
import ru.tsystems.tchallenge.service.kernel.validation.contract.InputMissingViolationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.contract.PropertyMissingViolationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.contract.ContractViolationInfo;

@Service
@Transactional(readOnly = true)
public class SimpleLogonPairValidatorBean extends GenericValidator implements SimpleLogonPairValidator {

    @Override
    public SimpleLogonPairInvoice ensure(final SimpleLogonPairInvoice pair) {
        return ensure(pair, this::validate);
    }

    @Override
    public Collection<? extends ContractViolationInfo> validate(final SimpleLogonPairInvoice pair) {
        final Collection<ContractViolationInfo> violations = new ArrayList<>();
        if (pair == null) {
            violations.add(new InputMissingViolationInfo("credential"));
        } else {
            if (pair.getLogin() == null) {
                violations.add(new PropertyMissingViolationInfo("login"));
            }
            if (pair.getSecret() == null) {
                violations.add(new PropertyMissingViolationInfo("secret"));
            }
        }
        return violations;
    }
}
