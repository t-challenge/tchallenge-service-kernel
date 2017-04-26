package ru.tsystems.tchallenge.service.kernel.domain.assignment;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.domain.assignment.status.AssignmentStatusRepository;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

@FacadeService
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
        final AuthenticationInfo authentication = this.getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final Assignment assignment = assignmentRepository.findById(invoice.getId());
        final AccountInfo account = authentication.getAccount();
        if (!account.getLogin().equals(assignment.getWorkbook().getCandidate().getAccount().getLogin())) {
            accessValidationExceptionEmitter.unauthorized();
        }
        assignment.setInput(invoice.getInput());
        assignment.setStatus(assignmentStatusRepository.findById("SUBMITTED"));
        assignmentRepository.save(assignment);
    }
}
