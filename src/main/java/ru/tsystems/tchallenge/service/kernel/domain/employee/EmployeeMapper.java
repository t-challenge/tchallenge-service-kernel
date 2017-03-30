package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountMapper;
import ru.tsystems.tchallenge.service.kernel.domain.employee.role.EmployeeRole;
import ru.tsystems.tchallenge.service.kernel.domain.shared.GenericMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeMapper extends GenericMapper {

    @Autowired
    private AccountMapper accountMapper;

    public EmployeeInfo employeeInfo(Employee employee) {
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setAccount(accountInfo(employee.getAccount()));
        employeeInfo.setFirstname(employee.getFirstname());
        employeeInfo.setLastname(employee.getLastname());
        employeeInfo.setRoles(roles(employee.getRoles()));
        return employeeInfo;
    }

    private AccountInfo accountInfo(Account account) {
        return accountMapper.accountInfo(account);
    }

    private Collection<String> roles(Collection<EmployeeRole> roles) {
        return roles.stream().map(EmployeeRole::getId).collect(Collectors.toList());
    }
}
