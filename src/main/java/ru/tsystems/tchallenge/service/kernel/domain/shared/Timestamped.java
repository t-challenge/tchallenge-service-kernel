package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import ru.tsystems.tchallenge.service.kernel.utility.Generators;

@MappedSuperclass
public abstract class Timestamped extends Persistent {

    @Column
    private Instant createdAt;

    @Column
    private Instant modifiedAt;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }

    @Override
    @PrePersist
    protected void onCreated() {
        super.onCreated();
        Instant now = Generators.now();
        createdAt = now;
        modifiedAt = now;
    }

    @Override
    @PreUpdate
    protected void onModified() {
        super.onModified();
        modifiedAt = Generators.now();
    }
}
