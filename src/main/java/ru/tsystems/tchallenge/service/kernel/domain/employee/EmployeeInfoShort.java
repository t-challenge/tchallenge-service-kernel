package ru.tsystems.tchallenge.service.kernel.domain.employee;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class EmployeeInfoShort extends GenericInfo {

    private String login;
    private String firstname;
    private String lastname;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
