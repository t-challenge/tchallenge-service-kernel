package ru.tsystems.tchallenge.service.kernel.domain.account.claim;

import java.time.Instant;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class AccountClaimInfo extends GenericInfo {

    private String email;
    private Instant createdAt;

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Instant createdAt) {
        this.createdAt = createdAt;
    }
}
