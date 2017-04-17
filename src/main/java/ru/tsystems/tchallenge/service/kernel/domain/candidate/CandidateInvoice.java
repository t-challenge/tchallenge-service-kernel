package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class CandidateInvoice extends GenericInvoice {

    private String github;

    public String getGithub() {
        return github;
    }

    public void setGithub(final String github) {
        this.github = github;
    }
}
