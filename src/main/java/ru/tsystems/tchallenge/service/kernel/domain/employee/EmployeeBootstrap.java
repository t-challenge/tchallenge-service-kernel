package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRoleBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.shared.BootstrapAwareService;
import ru.tsystems.tchallenge.service.kernel.domain.shared.GenericBootstrap;

@Component
public class EmployeeBootstrap extends GenericBootstrap<EmployeeProperties> {

    @Autowired
    private AccountRealmBootstrap accountRealmBootstrap;

    @Autowired
    private AccountStatusBootstrap accountStatusBootstrap;

    @Autowired
    private EmployeeRoleBootstrap roleBootstrap;

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected BootstrapAwareService<EmployeeProperties> getService() {
        return employeeService;
    }

    @Override
    protected void collectProperties(Collection<EmployeeProperties> employees) {
        employees.add(petrov());
        employees.add(kuznetcov());
    }

    private EmployeeProperties petrov() {
        return employee("ivan.petrov@some-email.com", "Иван", "Петров", "EVENT_MODERATOR");
    }

    private EmployeeProperties kuznetcov() {
        return employee("sergei.kuznetcov@some-email.com", "Сергей", "Кузнетцов", "TASK_MODERATOR");
    }

    private EmployeeProperties employee(String email, String firstname, String lastname, String... roles) {
        EmployeeProperties employeeProperties = new EmployeeProperties();
        employeeProperties.setEmail(email);
        employeeProperties.setLogin(email);
        employeeProperties.setSecret(email);
        employeeProperties.setFirstname(firstname);
        employeeProperties.setLastname(lastname);
        employeeProperties.setRoles(Arrays.asList(roles));
        return employeeProperties;
    }
}
