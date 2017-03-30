package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;

public class EmployeeInfo {

    private AccountInfo account;
    private String firstname;
    private String lastname;
    private Collection<String> roles;

    public AccountInfo getAccount() {
        return account;
    }

    public void setAccount(AccountInfo account) {
        this.account = account;
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

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }
}
