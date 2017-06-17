package ru.tchallenge.service.kernel.generic.entity;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import ru.tchallenge.service.kernel.utility.Generators;

@MappedSuperclass
public abstract class TimestampedEntity<ID extends Serializable> extends GenericEntity<ID> {

    @Column
    private Instant createdAt;

    @Column
    private Instant modifiedAt;

    public TimestampedEntity() {

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
        final Instant timestamp = timestamp();
        createdAt = timestamp;
        modifiedAt = timestamp;
    }

    @Override
    protected void onModified() {
        super.onModified();
        modifiedAt = timestamp();
    }

    private Instant timestamp() {
        return Generators.now();
    }
}
