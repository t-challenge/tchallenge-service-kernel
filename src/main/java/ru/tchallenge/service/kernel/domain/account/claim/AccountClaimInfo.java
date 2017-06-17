package ru.tchallenge.service.kernel.domain.account.claim;

import java.time.Instant;

import ru.tchallenge.service.kernel.generic.GenericInfo;

public final class AccountClaimInfo extends GenericInfo {

    private final String email;
    private final Instant createdAt;

    public AccountClaimInfo(final String email,
                            final Instant createdAt) {
        this.email = email;
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
