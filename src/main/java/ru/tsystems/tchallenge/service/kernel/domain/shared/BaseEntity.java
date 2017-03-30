package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    protected BaseEntity() {

    }

    public abstract ID getId();

    @PrePersist
    protected void onCreated() {

    }

    @PreUpdate
    protected void onModified() {

    }
}
