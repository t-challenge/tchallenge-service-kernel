package ru.tchallenge.service.kernel.domain.robot.role;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class RobotRoleMapper extends EnumeratedEntityMapper<RobotRole> {

    @Override
    protected RobotRole enumeratedEntity() {
        return new RobotRole();
    }
}
