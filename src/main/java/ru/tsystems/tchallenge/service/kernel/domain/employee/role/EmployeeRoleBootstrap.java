package ru.tsystems.tchallenge.service.kernel.domain.employee.role;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class EmployeeRoleBootstrap extends EnumeratedEntityBootstrap<EmployeeRole> {

    @Autowired
    private EmployeeRoleRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("CANDMOD");
        ids.add("CANDVIEW");
        ids.add("EVENTMOD");
        ids.add("EVENTVIEW");
        ids.add("TASKMOD");
        ids.add("TASKVIEW");
        ids.add("WBKMOD");
        ids.add("WBKVIEW");
        ids.add("USERMOD");
        ids.add("ADMIN");
    }

    @Override
    protected EmployeeRole enumerated(final String id) {
        return new EmployeeRole(id);
    }

    @Override
    protected GenericEntityRepository<EmployeeRole, String> getRepository() {
        return repository;
    }
}
