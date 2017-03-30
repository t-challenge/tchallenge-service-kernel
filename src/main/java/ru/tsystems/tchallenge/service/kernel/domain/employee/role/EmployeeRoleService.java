package ru.tsystems.tchallenge.service.kernel.domain.employee.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityRepository;
import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityService;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeRoleService extends EnumeratedEntityService<EmployeeRole> {

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Override
    protected EnumeratedEntityRepository<EmployeeRole> getRepository() {
        return employeeRoleRepository;
    }

    @Override
    protected EmployeeRole enumerated(String id) {
        return new EmployeeRole(id);
    }
}
