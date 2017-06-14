package ru.tsystems.tchallenge.service.kernel.domain.robot.role;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class RobotRoleMapper extends EnumeratedEntityMapper<RobotRole> {

    @Override
    protected RobotRole enumeratedEntity() {
        return new RobotRole();
    }
}
