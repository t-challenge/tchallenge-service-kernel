package ru.tchallenge.service.kernel.domain.robot;

import java.util.stream.Collectors;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.domain.robot.role.RobotRole;
import ru.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class RobotMapper extends GenericMapper {

    public RobotInfo info(final Robot robot) {
        final RobotInfo info = new RobotInfo();
        info.setTitle(robot.getTitle());
        info.setDescription(robot.getDescription());
        info.setRoles(robot.getRoles().stream().map(RobotRole::getId).collect(Collectors.toList()));
        return info;
    }
}
