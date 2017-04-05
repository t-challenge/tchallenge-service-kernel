package ru.tsystems.tchallenge.service.kernel.generic.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SequentialEntity extends OrdinalEntity {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    public SequentialEntity() {

    }

    @Override
    public Long getId() {
        return id;
    }
}
