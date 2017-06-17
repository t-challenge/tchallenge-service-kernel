package ru.tchallenge.service.kernel.security.token;

import java.time.Instant;

import ru.tchallenge.service.kernel.generic.GenericInfo;

public final class TokenInfo extends GenericInfo {

    private final String id;
    private final String login;
    private final Instant createdAt;

    public TokenInfo(final String id,
                     final String login,
                     final Instant createdAt) {
        this.id = id;
        this.login = login;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
