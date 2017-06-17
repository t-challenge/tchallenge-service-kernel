package ru.tchallenge.service.kernel.domain.candidate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ru.tchallenge.service.kernel.domain.account.Account;
import ru.tchallenge.service.kernel.generic.entity.SequentialEntity;

@Entity
public class Candidate extends SequentialEntity {

    @OneToOne
    private Account account;

    @Column
    private String github;

    @Column
    private Integer interested;

    @Column
    private String cv;

    @Column
    private String selfie;

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

    public Integer getInterested() {
        return interested;
    }

    public void setInterested(Integer interested) {
        this.interested = interested;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getSelfie() {
        return selfie;
    }

    public void setSelfie(String selfie) {
        this.selfie = selfie;
    }
}
