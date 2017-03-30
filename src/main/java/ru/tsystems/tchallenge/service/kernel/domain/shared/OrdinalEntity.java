package ru.tsystems.tchallenge.service.kernel.domain.shared;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class OrdinalEntity extends TimestampedEntity<Long> {

    protected OrdinalEntity() {

    }
}
