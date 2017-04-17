package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class CandidateInfo extends GenericInfo {

    private String github;

    public String getGithub() {
        return github;
    }

    public void setGithub(final String github) {
        this.github = github;
    }
}
