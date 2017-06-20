package ru.tchallenge.service.kernel.security.rescue;

import java.time.Instant;

import ru.tchallenge.service.kernel.generic.GenericInfo;

public final class RescueInfo extends GenericInfo {

    private final String id;
    private final String email;
    private final String url;
    private final Instant createdAt;

    public RescueInfo(final String id,
                      final String email,
                      final String url,
                      final Instant createdAt) {
        this.id = id;
        this.email = email;
        this.url = url;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUrl() {
        return url;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
