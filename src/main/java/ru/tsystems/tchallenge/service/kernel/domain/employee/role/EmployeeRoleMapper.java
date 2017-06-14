package ru.tsystems.tchallenge.service.kernel.domain.employee.role;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class EmployeeRoleMapper extends EnumeratedEntityMapper<EmployeeRole> {

    @Override
    protected EmployeeRole enumeratedEntity() {
        return new EmployeeRole();
    }
}
