package ru.tsystems.tchallenge.service.kernel.domain.maturity;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class Maturity extends EnumeratedEntity {

    public Maturity(final String id) {
        super(id);
    }

    @JpaConstructor
    protected Maturity() {

    }
}
