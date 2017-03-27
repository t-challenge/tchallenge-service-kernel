package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class Persistent {

    @PrePersist
    protected void onCreated() {

    }

    @PreUpdate
    protected void onModified() {

    }
}
