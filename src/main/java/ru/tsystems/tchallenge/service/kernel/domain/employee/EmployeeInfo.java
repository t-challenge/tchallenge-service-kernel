package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class EmployeeInfo extends GenericInfo {

    private Collection<String> roles;

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(final Collection<String> roles) {
        this.roles = roles;
    }
}
