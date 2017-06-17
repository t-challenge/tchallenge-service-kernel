package ru.tchallenge.service.kernel.generic.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SubsequentEntity extends OrdinalEntity {

    @Id
    @Column
    private Long id;

    protected SubsequentEntity() {

    }

    public SubsequentEntity(final Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
