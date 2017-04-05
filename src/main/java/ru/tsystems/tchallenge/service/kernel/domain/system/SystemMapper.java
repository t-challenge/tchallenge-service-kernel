package ru.tsystems.tchallenge.service.kernel.domain.system;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountMapper;
import ru.tsystems.tchallenge.service.kernel.domain.system.role.SystemRole;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@Service
public class SystemMapper extends GenericMapper {

    @Autowired
    private AccountMapper accountMapper;

    public SystemInfo systemInfo(System system) {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setAccount(accountInfo(system.getAccount()));
        systemInfo.setTitle(system.getTitle());
        systemInfo.setDescription(system.getDescription());
        systemInfo.setRoles(roles(system.getRoles()));
        return systemInfo;
    }

    private AccountInfo accountInfo(Account account) {
        return accountMapper.accountInfo(account);
    }

    private Collection<String> roles(Collection<SystemRole> roles) {
        return roles.stream().map(SystemRole::getId).collect(Collectors.toList());
    }
}
