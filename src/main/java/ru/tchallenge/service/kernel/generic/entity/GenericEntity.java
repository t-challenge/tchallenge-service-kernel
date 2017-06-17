package ru.tchallenge.service.kernel.generic.entity;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class GenericEntity<ID extends Serializable> implements Serializable {

    public abstract ID getId();

    @PrePersist
    protected void onCreated() {

    }

    @PreUpdate
    protected void onModified() {

    }
}
