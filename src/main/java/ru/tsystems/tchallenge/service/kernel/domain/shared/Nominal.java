package ru.tsystems.tchallenge.service.kernel.domain.shared;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Nominal extends Persistent {

    @Id
    @Column
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
