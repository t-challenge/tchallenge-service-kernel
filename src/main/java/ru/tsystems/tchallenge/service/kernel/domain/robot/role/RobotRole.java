package ru.tsystems.tchallenge.service.kernel.domain.robot.role;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.conventions.JpaConstructor;
import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class RobotRole extends EnumeratedEntity {

    public RobotRole(final String id) {
        super(id);
    }

    @JpaConstructor
    protected RobotRole() {

    }
}
