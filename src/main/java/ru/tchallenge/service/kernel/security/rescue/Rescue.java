package ru.tchallenge.service.kernel.security.rescue;

import java.time.Duration;
import java.time.Instant;

import ru.tchallenge.service.kernel.utility.Generators;

public final class Rescue {

    private final String id;
    private final String email;
    private final String url;
    private final Instant createdAt;

    public Rescue(final String email,
                  final String url) {
        this.id = Generators.uuid();
        this.email = email;
        this.url = url;
        this.createdAt = Generators.now();
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

    public boolean isDeactivated(final Duration deactivation) {
        return createdAt.plus(deactivation).isBefore(Instant.now());
    }
}
