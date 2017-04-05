package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRole;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SubsequentEntity;

@Entity
public class Employee extends SubsequentEntity {

    @OneToOne
    private Account account;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @ManyToMany
    private Collection<EmployeeRole> roles = new ArrayList<>();

    public Employee(Long id) {
        super(id);
    }

    protected Employee() {

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
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

    public Collection<EmployeeRole> getRoles() {
        return roles;
    }
}
