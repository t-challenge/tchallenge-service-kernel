package ru.tsystems.tchallenge.service.kernel.domain.robot.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/robots/roles")
public class RobotRoleController extends EnumeratedEntityController<RobotRole> {

    @Autowired
    private EnumeratedEntityFacade<RobotRole> facade;

    @Override
    protected EnumeratedEntityFacade<RobotRole> getFacade() {
        return facade;
    }
}
