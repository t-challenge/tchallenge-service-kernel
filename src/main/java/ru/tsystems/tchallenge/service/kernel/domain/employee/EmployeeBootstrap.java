package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRoleBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRoleRepository;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.GenericEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class EmployeeBootstrap extends GenericEntityBootstrap<Employee, Long> {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRoleRepository roleRepository;

    @Autowired
    private AccountBootstrap accountBootstrap;

    @Autowired
    private EmployeeRoleBootstrap roleBootstrap;

    @Override
    protected void collectEntities(final Collection<Employee> employees) {
        employees.add(petrov());
        employees.add(kuznetcov());
    }

    @Override
    protected GenericEntityRepository<Employee, Long> getRepository() {
        return repository;
    }

    private Employee petrov() {
        return employee("ivan.petrov@some-email.com", "Иван", "Петров", "EVENT_MODERATOR");
    }

    private Employee kuznetcov() {
        return employee("sergei.kuznetcov@some-email.com", "Сергей", "Кузнетцов", "TASK_MODERATOR");
    }

    private Employee employee(final String email,
                              final String firstname,
                              final String lastname,
                              final String... roles) {
        final Account account = accountRepository.findByEmail(email);
        Employee employee = new Employee(account.getId());
        employee.setAccount(account);
        employee.setFirstname(firstname);
        employee.setLastname(lastname);
        employee.getRoles().addAll(roleRepository.findAllById(Arrays.asList(roles)));
        return employee;
    }
}
