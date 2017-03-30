package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountProperties;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountService;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRole;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRoleRepository;
import ru.tsystems.tchallenge.service.kernel.domain.shared.BootstrapAwareService;
import ru.tsystems.tchallenge.service.kernel.domain.shared.GenericService;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeService extends GenericService implements BootstrapAwareService<EmployeeProperties> {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private AccountService accountService;

    @Override
    public EmployeeInfo bootstrap(EmployeeProperties employeeProperties) {
        bootstrapAccount(employeeProperties);
        return save(fromProperties(employeeProperties));
    }

    public EmployeeInfo create(EmployeeProperties employeeProperties) {
        createAccount(employeeProperties);
        return save(fromProperties(employeeProperties));
    }

    public Collection<EmployeeInfo> getAll() {
        return employeeRepository
                .findAll()
                .stream()
                .map(this::info)
                .collect(Collectors.toList());
    }

    public EmployeeInfo getByLogin(String login) {
        return info(byLogin(login));
    }

    private AccountInfo bootstrapAccount(EmployeeProperties employeeProperties) {
        return accountService.bootstrap(accountProperties(employeeProperties));
    }

    private AccountInfo createAccount(EmployeeProperties employeeProperties) {
        return accountService.create(accountProperties(employeeProperties));
    }

    private Employee byLogin(String login) {
        return employeeRepository.findByLogin(login);
    }

    private EmployeeInfo save(Employee employee) {
        return info(employeeRepository.save(employee));
    }

    private EmployeeInfo info(Employee employee) {
        return employeeMapper.employeeInfo(employee);
    }

    private Employee fromProperties(EmployeeProperties employeeProperties) {
        Account account = accountByLogin(employeeProperties.getLogin());
        Employee employee = new Employee(account.getId());
        employee.setAccount(account);
        employee.setFirstname(employeeProperties.getFirstname());
        employee.setLastname(employeeProperties.getLastname());
        employee.getRoles().addAll(roles(employeeProperties.getRoles()));
        return employee;
    }

    private Account accountByLogin(String login) {
        return accountRepository.findByLogin(login);
    }

    private AccountProperties accountProperties(EmployeeProperties employeeProperties) {
        AccountProperties accountProperties = new AccountProperties();
        accountProperties.setEmail(employeeProperties.getEmail());
        accountProperties.setLogin(employeeProperties.getLogin());
        accountProperties.setSecret(employeeProperties.getSecret());
        accountProperties.setRealm(employeeRealm());
        return accountProperties;
    }

    private Collection<EmployeeRole> roles(Collection<String> roles) {
        return employeeRoleRepository.findAllById(roles);
    }

    private String employeeRealm() {
        return "EMPLOYEE";
    }
}
