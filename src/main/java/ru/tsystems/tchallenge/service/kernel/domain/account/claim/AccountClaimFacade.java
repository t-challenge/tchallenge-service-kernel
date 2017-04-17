package ru.tsystems.tchallenge.service.kernel.domain.account.claim;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountService;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.CandidateInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.claim.CandidateClaimInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.employee.EmployeeInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.employee.claim.EmployeeClaimInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.person.PersonInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.person.claim.PersonClaimInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;

@FacadeService
public class AccountClaimFacade extends GenericFacade {

    @Autowired
    private AccountService accountService;

    public AccountClaimInfo create(final AccountClaimInvoice invoice) {
        return info(accountService.create(accountInvoice(invoice)));
    }

    public Object validate(final AccountClaimInvoice invoice) {
        throw new UnsupportedOperationException();
    }

    private AccountClaimInfo info(final AccountInfo accountInfo) {
        final AccountClaimInfo info = new AccountClaimInfo();
        info.setEmail(accountInfo.getEmail());
        return info;
    }

    private AccountInvoice accountInvoice(final AccountClaimInvoice invoice) {
        final AccountInvoice accountInvoice = new AccountInvoice();
        accountInvoice.setEmail(invoice.getEmail());
        accountInvoice.setLogin(invoice.getLogin() != null ? invoice.getLogin() : invoice.getEmail());
        accountInvoice.setRealm(invoice.getRealm());
        accountInvoice.setSecret(invoice.getSecret() != null ? invoice.getSecret() : "123");
        switch (invoice.getRealm()) {
            case "CANDIDATE":
                accountInvoice.setCandidate(candidateInvoice(invoice.getCandidate()));
                accountInvoice.setPerson(personInvoice(invoice.getPerson()));
                break;
            case "EMPLOYEE":
                accountInvoice.setEmployee(employeeInvoice(invoice.getEmployee()));
                accountInvoice.setPerson(personInvoice(invoice.getPerson()));
                break;
            default:
                throw new UnsupportedOperationException("realm is not supported");
        }
        return accountInvoice;
    }

    private CandidateInvoice candidateInvoice(final CandidateClaimInvoice invoice) {
        return new CandidateInvoice();
    }

    private EmployeeInvoice employeeInvoice(final EmployeeClaimInvoice invoice) {
        return new EmployeeInvoice();
    }

    private PersonInvoice personInvoice(final PersonClaimInvoice invoice) {
        final PersonInvoice personInvoice = new PersonInvoice();
        personInvoice.setFirstname(invoice.getFirstname());
        personInvoice.setLastname(invoice.getLastname());
        personInvoice.setQuickname(invoice.getQuickname());
        return personInvoice;
    }
}
