package ru.tsystems.tchallenge.service.kernel.domain.system.role;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@Component
public class SystemRoleBootstrap extends EnumeratedEntityBootstrap<SystemRole> {

    @Autowired
    private SystemRoleRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("CANDIDATE_VIEWER");
    }

    @Override
    protected SystemRole enumerated(final String id) {
        return new SystemRole(id);
    }

    @Override
    protected GenericEntityRepository<SystemRole, String> getRepository() {
        return repository;
    }
}
