package ru.tchallenge.service.kernel.domain.robot.role;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@ServiceComponent
public class RobotRoleFacade extends EnumeratedEntityFacade<RobotRole> {

    @Autowired
    private EnumeratedEntityMapper<RobotRole> mapper;

    @Autowired
    private EnumeratedEntityRepository<RobotRole> repository;

    @Override
    protected EnumeratedEntityMapper<RobotRole> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<RobotRole> getRepository() {
        return repository;
    }
}
