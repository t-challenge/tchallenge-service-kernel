package ru.tchallenge.service.kernel.domain.assignment;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.FacadeServiceComponent;
import ru.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tchallenge.service.kernel.domain.assignment.status.AssignmentStatusRepository;
import ru.tchallenge.service.kernel.generic.GenericFacade;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;
import ru.tchallenge.service.kernel.validation.contract.ContractValidationException;
import ru.tchallenge.service.kernel.validation.contract.PropertyContractViolationInfo;

@FacadeServiceComponent
public class AssignmentFacade extends GenericFacade {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentStatusRepository assignmentStatusRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    public void update(final AssignmentInvoice invoice) {
        final AuthenticationInfo authentication = this.getAuthenticationContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final Assignment assignment = assignmentRepository.findById(invoice.getId());
        final AccountInfo account = authentication.getAccount();
        if (!account.getLogin().equals(assignment.getWorkbook().getCandidate().getAccount().getLogin())) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final String currentStatus = assignment.getStatus().getId();
        if (currentStatus.equals("ASSESSED")) {
            throw new ContractValidationException(Collections.singleton(new PropertyContractViolationInfo("status", "ASSESSED", "already assessed")));
        }
        assignment.setInput(invoice.getInput());
        assignment.setStatus(assignmentStatusRepository.findById("SUBMITTED"));
        assignmentRepository.save(assignment);
    }
}
