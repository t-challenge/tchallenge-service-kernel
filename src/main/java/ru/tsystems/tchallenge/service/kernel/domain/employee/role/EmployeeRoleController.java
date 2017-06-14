package ru.tsystems.tchallenge.service.kernel.domain.employee.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/employees/roles")
public class EmployeeRoleController extends EnumeratedEntityController<EmployeeRole> {

    @Autowired
    private EnumeratedEntityFacade<EmployeeRole> facade;

    @Override
    protected EnumeratedEntityFacade<EmployeeRole> getFacade() {
        return facade;
    }
}
