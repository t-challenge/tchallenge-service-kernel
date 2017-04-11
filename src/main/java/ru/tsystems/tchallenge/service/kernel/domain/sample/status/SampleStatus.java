package ru.tsystems.tchallenge.service.kernel.domain.sample.status;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class SampleStatus extends EnumeratedEntity {

    public SampleStatus(final String id) {
        super(id);
    }

    @JpaConstructor
    protected SampleStatus() {

    }
}
