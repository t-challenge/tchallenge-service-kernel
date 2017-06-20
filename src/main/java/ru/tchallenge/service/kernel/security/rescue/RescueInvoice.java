package ru.tchallenge.service.kernel.security.rescue;

import ru.tchallenge.service.kernel.generic.GenericInvoice;

public final class RescueInvoice extends GenericInvoice {

    private String email;
    private String url;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}
