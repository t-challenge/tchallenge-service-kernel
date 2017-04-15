package ru.tsystems.tchallenge.service.kernel.domain.account.claim;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class AccountClaimInvoice extends GenericInvoice {

    private String email;
    private String realm;
    private String shortname;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(final String realm) {
        this.realm = realm;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(final String shortname) {
        this.shortname = shortname;
    }
}
