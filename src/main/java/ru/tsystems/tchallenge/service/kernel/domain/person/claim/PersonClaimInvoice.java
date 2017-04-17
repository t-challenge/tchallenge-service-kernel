package ru.tsystems.tchallenge.service.kernel.domain.person.claim;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class PersonClaimInvoice extends GenericInvoice {

    private String firstname;
    private String lastname;
    private String quickname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getQuickname() {
        return quickname;
    }

    public void setQuickname(final String quickname) {
        this.quickname = quickname;
    }
}
