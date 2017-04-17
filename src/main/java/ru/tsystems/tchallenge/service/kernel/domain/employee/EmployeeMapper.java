package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.stream.Collectors;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRole;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class EmployeeMapper extends GenericMapper {

    public EmployeeInfo info(final Employee employee) {
        final EmployeeInfo info = new EmployeeInfo();
        info.setRoles(employee.getRoles().stream().map(EmployeeRole::getId).collect(Collectors.toList()));
        return info;
    }
}
