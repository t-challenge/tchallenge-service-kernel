package ru.tchallenge.service.kernel.domain.person;

import ru.tchallenge.service.kernel.generic.GenericInvoice;

public final class PersonInvoice extends GenericInvoice {

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
