package ru.tsystems.tchallenge.service.kernel.generic.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;

@MappedSuperclass
public abstract class EnumeratedEntity extends GenericEntity<String> {

    @Id
    @Column
    private String id;

    public EnumeratedEntity(final String id) {
        this.id = id;
    }

    @JpaConstructor
    protected EnumeratedEntity() {

    }

    @Override
    public String getId() {
        return id;
    }
}
