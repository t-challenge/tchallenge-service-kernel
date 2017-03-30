package ru.tsystems.tchallenge.service.kernel.domain.system.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityRepository;
import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityService;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SystemRoleService extends EnumeratedEntityService<SystemRole> {

    @Autowired
    private SystemRoleRepository systemRoleRepository;

    @Override
    protected EnumeratedEntityRepository<SystemRole> getRepository() {
        return systemRoleRepository;
    }

    @Override
    protected SystemRole enumerated(String id) {
        return new SystemRole(id);
    }
}
