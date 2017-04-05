package ru.tsystems.tchallenge.service.kernel.domain.system;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountInvoice;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountService;
import ru.tsystems.tchallenge.service.kernel.domain.system.role.SystemRole;
import ru.tsystems.tchallenge.service.kernel.domain.system.role.SystemRoleRepository;
import ru.tsystems.tchallenge.service.kernel.generic.GenericService;

@Service
public class SystemService extends GenericService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SystemRepository systemRepository;

    @Autowired
    private SystemRoleRepository systemRoleRepository;

    @Autowired
    private SystemMapper systemMapper;

    @Autowired
    private AccountService accountService;

    public SystemInfo create(SystemProperties systemProperties) {
        createAccount(systemProperties);
        return save(fromProperties(systemProperties));
    }

    public Collection<SystemInfo> getAll() {
        return systemRepository
                .findAll()
                .stream()
                .map(this::info)
                .collect(Collectors.toList());
    }

    public SystemInfo getByLogin(String login) {
        return info(byLogin(login));
    }

    private AccountInfo createAccount(SystemProperties systemProperties) {
        return accountService.create(accountProperties(systemProperties));
    }

    private System byLogin(String login) {
        return systemRepository.findByLogin(login);
    }

    private SystemInfo save(System system) {
        return info(systemRepository.save(system));
    }

    private SystemInfo info(System system) {
        return systemMapper.systemInfo(system);
    }

    private System fromProperties(SystemProperties systemProperties) {
        Account account = accountByLogin(systemProperties.getLogin());
        System system = new System(account.getId());
        system.setAccount(account);
        system.setTitle(systemProperties.getTitle());
        system.setDescription(systemProperties.getDescription());
        system.getRoles().addAll(roles(systemProperties.getRoles()));
        return system;
    }

    private Account accountByLogin(String login) {
        return accountRepository.findByLogin(login);
    }

    private AccountInvoice accountProperties(SystemProperties systemProperties) {
        AccountInvoice accountProperties = new AccountInvoice();
        accountProperties.setEmail(systemProperties.getEmail());
        accountProperties.setLogin(systemProperties.getLogin());
        accountProperties.setSecret(systemProperties.getSecret());
        accountProperties.setRealm(systemRealm());
        return accountProperties;
    }

    private Collection<SystemRole> roles(Collection<String> roles) {
        return systemRoleRepository.findAllById(roles);
    }

    private String systemRealm() {
        return "SYSTEM";
    }
}
