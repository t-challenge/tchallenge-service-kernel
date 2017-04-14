package ru.tsystems.tchallenge.service.kernel.domain.specialization;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class Specialization extends EnumeratedEntity {

    public Specialization(final String id) {
        super(id);
    }

    @JpaConstructor
    protected Specialization() {

    }
}
