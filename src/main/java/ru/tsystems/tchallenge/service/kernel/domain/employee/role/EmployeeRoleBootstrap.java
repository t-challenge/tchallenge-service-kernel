package ru.tsystems.tchallenge.service.kernel.domain.employee.role;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.domain.shared.BootstrapAwareService;
import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityBootstrap;

@Component
public class EmployeeRoleBootstrap extends EnumeratedEntityBootstrap {

    @Autowired
    private EmployeeRoleService employeeRoleService;

    @Override
    protected BootstrapAwareService<String> getService() {
        return employeeRoleService;
    }

    @Override
    protected void collectProperties(Collection<String> ids) {
        ids.add("TASK_MODERATOR");
        ids.add("EVENT_MODERATOR");
    }
}
