package ru.tsystems.tchallenge.service.kernel.domain.account;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ru.tsystems.tchallenge.service.kernel.domain.candidate.Candidate;
import ru.tsystems.tchallenge.service.kernel.domain.employee.Employee;
import ru.tsystems.tchallenge.service.kernel.domain.person.Person;
import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealm;
import ru.tsystems.tchallenge.service.kernel.domain.robot.Robot;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatus;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Account extends SequentialEntity {

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String secretHash;

    @ManyToOne
    private AccountRealm realm;

    @ManyToOne
    private AccountStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    private Candidate candidate;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private Robot robot;

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

    public String getSecretHash() {
        return secretHash;
    }

    public void setSecretHash(final String secretHash) {
        this.secretHash = secretHash;
    }

    public AccountRealm getRealm() {
        return realm;
    }

    public void setRealm(final AccountRealm realm) {
        this.realm = realm;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(final AccountStatus status) {
        this.status = status;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(final Candidate candidate) {
        candidate.setAccount(this);
        this.candidate = candidate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        employee.setAccount(this);
        this.employee = employee;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(final Person person) {
        person.setAccount(this);
        this.person = person;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(final Robot robot) {
        robot.setAccount(this);
        this.robot = robot;
    }
}
