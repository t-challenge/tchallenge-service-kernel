package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class CandidateInfo extends GenericInfo {

    private String github;
    private Boolean interested;
    private String cv;
    private String selfie;

    public String getGithub() {
        return github;
    }

    public void setGithub(final String github) {
        this.github = github;
    }

    public Boolean getInterested() {
        return interested;
    }

    public void setInterested(Boolean interested) {
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
