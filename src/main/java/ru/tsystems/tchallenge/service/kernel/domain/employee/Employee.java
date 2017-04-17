package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRole;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Employee extends SequentialEntity {

    @OneToOne
    private Account account;

    @ManyToMany
    private Collection<EmployeeRole> roles = new ArrayList<>();

    public Account getAccount() {
        return account;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }

    public Collection<EmployeeRole> getRoles() {
        return roles;
    }

    public void setRoles(final Collection<EmployeeRole> roles) {
        this.roles = roles;
    }
}
