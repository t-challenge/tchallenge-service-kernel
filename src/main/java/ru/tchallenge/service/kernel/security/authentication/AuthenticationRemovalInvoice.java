package ru.tchallenge.service.kernel.security.authentication;

import ru.tchallenge.service.kernel.generic.GenericInvoice;

public final class AuthenticationRemovalInvoice extends GenericInvoice {

    private Boolean all;

    public Boolean getAll() {
        return all;
    }

    public void setAll(final Boolean all) {
        this.all = all;
    }
}
