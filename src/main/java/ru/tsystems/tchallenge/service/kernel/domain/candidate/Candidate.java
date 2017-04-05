package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SubsequentEntity;

@Entity
public class Candidate extends SubsequentEntity {

    @OneToOne
    private Account account;

    @Column
    private String firstname;

    @Column
    private String lastname;

    public Candidate(Long id) {
        super(id);
    }

    protected Candidate() {

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
