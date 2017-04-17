package ru.tsystems.tchallenge.service.kernel.domain.account.claim;

import ru.tsystems.tchallenge.service.kernel.domain.candidate.claim.CandidateClaimInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.employee.claim.EmployeeClaimInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.person.claim.PersonClaimInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public class AccountClaimInvoice extends GenericInvoice {

    private String email;
    private String login;
    private String realm;
    private String secret;
    private CandidateClaimInvoice candidate;
    private EmployeeClaimInvoice employee;
    private PersonClaimInvoice person;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(final String realm) {
        this.realm = realm;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(final String secret) {
        this.secret = secret;
    }

    public CandidateClaimInvoice getCandidate() {
        return candidate;
    }

    public void setCandidate(final CandidateClaimInvoice candidate) {
        this.candidate = candidate;
    }

    public EmployeeClaimInvoice getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeClaimInvoice employee) {
        this.employee = employee;
    }

    public PersonClaimInvoice getPerson() {
        return person;
    }

    public void setPerson(final PersonClaimInvoice person) {
        this.person = person;
    }
}
