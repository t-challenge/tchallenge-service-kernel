package ru.tchallenge.service.kernel.domain.employee;

import java.util.stream.Collectors;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.domain.employee.role.EmployeeRole;
import ru.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class EmployeeMapper extends GenericMapper {

    public EmployeeInfo info(final Employee employee) {
        final EmployeeInfo info = new EmployeeInfo();
        info.setRoles(employee.getRoles().stream().map(EmployeeRole::getId).collect(Collectors.toList()));
        return info;
    }
}
