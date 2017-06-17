package ru.tchallenge.service.kernel.domain.account;

import ru.tchallenge.service.kernel.domain.candidate.CandidateInfo;
import ru.tchallenge.service.kernel.domain.employee.EmployeeInfo;
import ru.tchallenge.service.kernel.domain.person.PersonInfo;
import ru.tchallenge.service.kernel.domain.robot.RobotInfo;
import ru.tchallenge.service.kernel.generic.GenericInfo;

public final class AccountInfo extends GenericInfo {

    private String email;
    private String login;
    private String realm;
    private String status;
    private CandidateInfo candidate;
    private EmployeeInfo employee;
    private PersonInfo person;
    private RobotInfo robot;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public CandidateInfo getCandidate() {
        return candidate;
    }

    public void setCandidate(final CandidateInfo candidate) {
        this.candidate = candidate;
    }

    public EmployeeInfo getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeInfo employee) {
        this.employee = employee;
    }

    public PersonInfo getPerson() {
        return person;
    }

    public void setPerson(final PersonInfo person) {
        this.person = person;
    }

    public RobotInfo getRobot() {
        return robot;
    }

    public void setRobot(final RobotInfo robot) {
        this.robot = robot;
    }
}
