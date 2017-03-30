package ru.tsystems.tchallenge.service.kernel.domain.system.role;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.domain.shared.BootstrapAwareService;
import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityBootstrap;

@Component
public class SystemRoleBootstrap extends EnumeratedEntityBootstrap {

    @Autowired
    private SystemRoleService systemRoleService;

    @Override
    protected BootstrapAwareService<String> getService() {
        return systemRoleService;
    }

    @Override
    protected void collectProperties(Collection<String> ids) {
        ids.add("CANDIDATE_VIEWER");
    }
}
