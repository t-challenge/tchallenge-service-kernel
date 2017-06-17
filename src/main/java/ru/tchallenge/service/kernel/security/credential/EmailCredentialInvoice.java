package ru.tchallenge.service.kernel.security.credential;

import ru.tchallenge.service.kernel.generic.GenericInvoice;

public final class EmailCredentialInvoice extends GenericInvoice {

    private String email;
    private String flashback;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getFlashback() {
        return flashback;
    }

    public void setFlashback(String flashback) {
        this.flashback = flashback;
    }
}
