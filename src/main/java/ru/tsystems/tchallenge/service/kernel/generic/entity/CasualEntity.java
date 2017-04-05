package ru.tsystems.tchallenge.service.kernel.generic.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ru.tsystems.tchallenge.service.kernel.utility.Generators;

@MappedSuperclass
public abstract class CasualEntity extends TimestampedEntity<String> {

    @Id
    @Column
    private String id;

    public CasualEntity() {

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    protected void onCreated() {
        super.onCreated();
        id = Generators.uuid();
    }
}
