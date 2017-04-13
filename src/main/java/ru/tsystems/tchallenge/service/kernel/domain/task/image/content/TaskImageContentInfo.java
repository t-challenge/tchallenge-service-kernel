package ru.tsystems.tchallenge.service.kernel.domain.task.image.content;

import java.time.Instant;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class TaskImageContentInfo extends GenericInfo {

    private final String id;
    private final byte[] binaryData;
    private final Instant createdAt;

    public TaskImageContentInfo(final String id,
                                final byte[] binaryData,
                                final Instant createdAt) {
        this.id = id;
        this.binaryData = binaryData;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public byte[] getBinaryData() {
        return binaryData;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
