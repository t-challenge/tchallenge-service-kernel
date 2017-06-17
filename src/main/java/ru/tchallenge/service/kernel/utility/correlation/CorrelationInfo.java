package ru.tchallenge.service.kernel.utility.correlation;

import java.time.Instant;

import ru.tchallenge.service.kernel.generic.GenericInfo;
import ru.tchallenge.service.kernel.utility.Generators;

public final class CorrelationInfo extends GenericInfo {

    private final String id;
    private final Instant createdAt;

    public CorrelationInfo() {
        this.id = Generators.uuid();
        this.createdAt = Generators.now();
    }

    public String getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
