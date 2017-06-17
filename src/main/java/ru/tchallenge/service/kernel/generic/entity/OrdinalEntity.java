package ru.tchallenge.service.kernel.generic.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class OrdinalEntity extends TimestampedEntity<Long> {

    public OrdinalEntity() {

    }
}
