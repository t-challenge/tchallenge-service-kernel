package ru.tchallenge.service.kernel.security.token;

import ru.tchallenge.service.kernel.generic.GenericInvoice;

public final class TokenInvoice extends GenericInvoice {

    private String login;

    public TokenInvoice() {

    }

    public TokenInvoice(final String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }
}
