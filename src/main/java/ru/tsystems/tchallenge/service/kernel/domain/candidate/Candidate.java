package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Candidate extends SequentialEntity {

    @OneToOne
    private Account account;

    @Column
    private String github;

    public Account getAccount() {
        return account;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(final String github) {
        this.github = github;
    }
}
