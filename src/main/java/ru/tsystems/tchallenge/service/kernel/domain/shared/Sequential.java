package ru.tsystems.tchallenge.service.kernel.domain.shared;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Sequential extends Timestamped {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    public Long getId() {
        return id;
    }
}
