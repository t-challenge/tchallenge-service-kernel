package ru.tsystems.tchallenge.service.kernel.domain.robot.role;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class RobotRoleBootstrap extends EnumeratedEntityBootstrap<RobotRole> {

    @Autowired
    private RobotRoleRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("CANDIDATE_VIEWER");
    }

    @Override
    protected RobotRole enumerated(final String id) {
        return new RobotRole(id);
    }

    @Override
    protected GenericEntityRepository<RobotRole, String> getRepository() {
        return repository;
    }
}
