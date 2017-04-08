package ru.tsystems.tchallenge.service.kernel.domain.system.role;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class SystemRole extends EnumeratedEntity {

    public SystemRole(final String id) {
        super(id);
    }

    @JpaConstructor
    protected SystemRole() {

    }
}
