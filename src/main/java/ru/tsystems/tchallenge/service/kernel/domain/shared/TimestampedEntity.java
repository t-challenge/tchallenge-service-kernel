package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import ru.tsystems.tchallenge.service.kernel.utility.Generators;

@MappedSuperclass
public abstract class TimestampedEntity<ID extends Serializable> extends BaseEntity<ID> {

    @Column
    private Instant createdAt;

    @Column
    private Instant modifiedAt;

    protected TimestampedEntity() {

    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }

    @Override
    protected void onCreated() {
        super.onCreated();
        Instant timestamp = Generators.now();
        createdAt = timestamp;
        modifiedAt = timestamp;
    }

    @Override
    protected void onModified() {
        super.onCreated();
        modifiedAt = Instant.now();
    }
}
