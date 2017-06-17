package ru.tchallenge.service.kernel.domain.account;

import java.util.Collection;

import ru.tchallenge.service.kernel.domain.candidate.CandidateInvoice;
import ru.tchallenge.service.kernel.domain.employee.EmployeeInvoice;
import ru.tchallenge.service.kernel.domain.person.PersonInvoice;
import ru.tchallenge.service.kernel.domain.robot.RobotInvoice;
import ru.tchallenge.service.kernel.generic.GenericInvoice;

public final class AccountInvoice extends GenericInvoice {

    private Collection<String> updatedProperties;
    private String email;
    private String login;
    private String loginExisting;
    private String secret;
    private String realm;
    private String status;
    private CandidateInvoice candidate;
    private EmployeeInvoice employee;
    private PersonInvoice person;
    private RobotInvoice robot;

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

    public String getLoginExisting() {
        return loginExisting;
    }

    public void setLoginExisting(final String loginExisting) {
        this.loginExisting = loginExisting;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(final String secret) {
        this.secret = secret;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(final String realm) {
        this.realm = realm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public CandidateInvoice getCandidate() {
        return candidate;
    }

    public void setCandidate(final CandidateInvoice candidate) {
        this.candidate = candidate;
    }

    public EmployeeInvoice getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeInvoice employee) {
        this.employee = employee;
    }

    public PersonInvoice getPerson() {
        return person;
    }

    public void setPerson(final PersonInvoice person) {
        this.person = person;
    }

    public RobotInvoice getRobot() {
        return robot;
    }

    public void setRobot(final RobotInvoice robot) {
        this.robot = robot;
    }

    public Collection<String> getUpdatedProperties() {
        return updatedProperties;
    }

    public void setUpdatedProperties(Collection<String> updatedProperties) {
        this.updatedProperties = updatedProperties;
    }
}
