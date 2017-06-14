package ru.tsystems.tchallenge.service.kernel.domain.robot.role;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class RobotRoleBootstrap extends EnumeratedEntityBootstrap<RobotRole> {

    @Autowired
    private EnumeratedEntityMapper<RobotRole> mapper;

    @Autowired
    private EnumeratedEntityRepository<RobotRole> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("CANDVIEW", "Просмотрщик кандидатов"));
    }

    @Override
    protected EnumeratedEntityMapper<RobotRole> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<RobotRole> getRepository() {
        return repository;
    }
}
