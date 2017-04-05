package ru.tsystems.tchallenge.service.kernel.domain.employee.role;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class EmployeeRole extends EnumeratedEntity {

    public EmployeeRole(String id) {
        super(id);
    }

    protected EmployeeRole() {

    }
}
