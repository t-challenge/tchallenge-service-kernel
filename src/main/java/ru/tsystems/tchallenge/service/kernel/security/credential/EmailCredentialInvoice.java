package ru.tsystems.tchallenge.service.kernel.security.credential;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class EmailCredentialInvoice extends GenericInvoice {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
