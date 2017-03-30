package ru.tsystems.tchallenge.service.kernel.domain.shared;

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

    protected SequentialEntity() {

    }

    @Override
    public Long getId() {
        return id;
    }
}
