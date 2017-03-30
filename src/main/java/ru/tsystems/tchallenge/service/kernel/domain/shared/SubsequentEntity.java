package ru.tsystems.tchallenge.service.kernel.domain.shared;

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

    protected SubsequentEntity(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
