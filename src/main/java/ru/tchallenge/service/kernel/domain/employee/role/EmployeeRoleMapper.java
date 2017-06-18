package ru.tchallenge.service.kernel.domain.employee.role;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class EmployeeRoleMapper extends EnumeratedEntityMapper<EmployeeRole> {

    @Override
    protected EmployeeRole enumeratedEntity() {
        return new EmployeeRole();
    }
}
