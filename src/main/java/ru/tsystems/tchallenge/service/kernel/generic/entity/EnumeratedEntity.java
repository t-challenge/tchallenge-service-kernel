package ru.tsystems.tchallenge.service.kernel.generic.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EnumeratedEntity extends GenericEntity<String> {

    @Id
    @Column
    private String id;

    protected EnumeratedEntity() {

    }

    public EnumeratedEntity(final String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
