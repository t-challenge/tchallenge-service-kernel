package ru.tsystems.tchallenge.service.kernel.domain.system;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tsystems.tchallenge.service.kernel.domain.system.role.SystemRoleBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.system.role.SystemRoleRepository;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.GenericEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class SystemBootstrap extends GenericEntityBootstrap<System, Long> {

    @Autowired
    private SystemRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SystemRoleRepository roleRepository;

    @Autowired
    private AccountBootstrap accountBootstrap;

    @Autowired
    private SystemRoleBootstrap roleBootstrap;

    @Override
    protected void collectEntities(final Collection<System> entities) {
        entities.add(systemA());
    }

    @Override
    protected GenericEntityRepository<System, Long> getRepository() {
        return repository;
    }

    private System systemA() {
        return system("system.a@some-email.com", "System A", "Some system A", "CANDIDATE_VIEWER");
    }

    private System system(final String email,
                          final String title,
                          final String description,
                          final String... roles) {
        final Account account = accountRepository.findByEmail(email);
        final System system = new System(account.getId());
        system.setAccount(account);
        system.setTitle(title);
        system.setDescription(description);
        system.getRoles().addAll(roleRepository.findAllById(Arrays.asList(roles)));
        return system;
    }
}
