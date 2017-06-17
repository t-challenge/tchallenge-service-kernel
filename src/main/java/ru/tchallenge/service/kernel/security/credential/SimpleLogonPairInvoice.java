package ru.tchallenge.service.kernel.security.credential;

public final class SimpleLogonPairInvoice extends CredentialInvoice {

    private String login;
    private String secret;

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(final String secret) {
        this.secret = secret;
    }
}
