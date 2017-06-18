package ru.tchallenge.service.kernel.domain.robot.role;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/robots/roles")
public class RobotRoleController extends EnumeratedEntityController<RobotRole> {

    @Autowired
    private EnumeratedEntityFacade<RobotRole> facade;

    @Override
    protected EnumeratedEntityFacade<RobotRole> getFacade() {
        return facade;
    }
}
