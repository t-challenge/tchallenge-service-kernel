package ru.tsystems.tchallenge.service.kernel.domain.employee.claim;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class EmployeeClaimInvoice extends GenericInvoice {

    private Collection<String> roles;

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(final Collection<String> roles) {
        this.roles = roles;
    }
}
