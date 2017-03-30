package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<EmployeeInfo> getAll() {
        return employeeService.getAll();
    }

    @RequestMapping(path = "/{login}", method = RequestMethod.GET)
    public EmployeeInfo getByLogin(@PathVariable("login") String login) {
        return employeeService.getByLogin(login);
    }
}
