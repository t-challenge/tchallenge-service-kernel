package ru.tsystems.tchallenge.service.kernel.domain.shared;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EnumeratedEntity extends BaseEntity<String> {

    @Id
    @Column
    private String id;

    protected EnumeratedEntity() {

    }

    protected EnumeratedEntity(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
