package ru.tchallenge.service.kernel.security.authentication;

import ru.tchallenge.service.kernel.generic.GenericInvoice;

public final class AuthenticationCreationInvoice extends GenericInvoice {

    private String login;
    private String password;
    private Boolean rescueMode;
    private String rescueId;

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Boolean getRescueMode() {
        return rescueMode;
    }

    public void setRescueMode(Boolean rescueMode) {
        this.rescueMode = rescueMode;
    }

    public String getRescueId() {
        return rescueId;
    }

    public void setRescueId(final String rescueId) {
        this.rescueId = rescueId;
    }
}
