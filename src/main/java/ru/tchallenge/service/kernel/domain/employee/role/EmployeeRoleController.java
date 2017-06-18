package ru.tchallenge.service.kernel.domain.employee.role;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/employees/roles")
public class EmployeeRoleController extends EnumeratedEntityController<EmployeeRole> {

    @Autowired
    private EnumeratedEntityFacade<EmployeeRole> facade;

    @Override
    protected EnumeratedEntityFacade<EmployeeRole> getFacade() {
        return facade;
    }
}
