package ru.tsystems.tchallenge.service.kernel.domain.shared;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ru.tsystems.tchallenge.service.kernel.utility.Generators;

@MappedSuperclass
public abstract class Casual extends Timestamped {

    @Id
    @Column
    private String id;

    public String getId() {
        return id;
    }

    @Override
    protected void onCreated() {
        super.onCreated();
        id = Generators.uuid();
    }
}
