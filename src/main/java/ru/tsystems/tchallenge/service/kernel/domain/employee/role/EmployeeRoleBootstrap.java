package ru.tsystems.tchallenge.service.kernel.domain.employee.role;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@Component
public class EmployeeRoleBootstrap extends EnumeratedEntityBootstrap<EmployeeRole> {

    @Autowired
    private EmployeeRoleRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("TASK_MODERATOR");
        ids.add("EVENT_MODERATOR");
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
