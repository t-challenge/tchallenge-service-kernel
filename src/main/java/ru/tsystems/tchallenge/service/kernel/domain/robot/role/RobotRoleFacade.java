package ru.tsystems.tchallenge.service.kernel.domain.robot.role;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
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
