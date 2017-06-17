package ru.tchallenge.service.kernel.domain.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ru.tchallenge.service.kernel.domain.account.Account;
import ru.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Person extends SequentialEntity {

    @OneToOne
    private Account account;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String quickname;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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
