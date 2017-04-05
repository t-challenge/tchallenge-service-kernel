package ru.tsystems.tchallenge.service.kernel.security.token;

import java.time.Instant;

import ru.tsystems.tchallenge.service.kernel.utility.Generators;

public final class Token {

    private final String id;
    private final String login;
    private final Instant createdAt;

    private volatile Instant lastUsedAt;

    public Token(final String login) {
        this.id = Generators.uuid();
        this.login = login;
        this.createdAt = Generators.now();
        this.lastUsedAt = this.createdAt;
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

    public Instant getLastUsedAt() {
        return lastUsedAt;
    }

    public void updateLastUsedAt() {
        this.lastUsedAt = Generators.now();
    }
}
