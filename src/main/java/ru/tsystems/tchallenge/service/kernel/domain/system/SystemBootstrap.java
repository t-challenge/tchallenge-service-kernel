package ru.tsystems.tchallenge.service.kernel.domain.system;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealmBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatusBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.shared.BootstrapAwareService;
import ru.tsystems.tchallenge.service.kernel.domain.shared.GenericBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.system.role.SystemRoleBootstrap;

@Component
public class SystemBootstrap extends GenericBootstrap<SystemProperties> {

    @Autowired
    private AccountRealmBootstrap accountRealmBootstrap;

    @Autowired
    private AccountStatusBootstrap accountStatusBootstrap;

    @Autowired
    private SystemRoleBootstrap systemRoleBootstrap;

    @Autowired
    private SystemService systemService;

    @Override
    protected BootstrapAwareService<SystemProperties> getService() {
        return systemService;
    }

    @Override
    protected void collectProperties(Collection<SystemProperties> systems) {
        systems.add(systemA());
    }

    private SystemProperties systemA() {
        return employee("system.a@some-email.com", "System A", "Some system A", "CANDIDATE_VIEWER");
    }

    private SystemProperties employee(String email, String title, String description, String... roles) {
        SystemProperties systemProperties = new SystemProperties();
        systemProperties.setEmail(email);
        systemProperties.setLogin(email);
        systemProperties.setSecret(email);
        systemProperties.setTitle(title);
        systemProperties.setDescription(description);
        systemProperties.setRoles(Arrays.asList(roles));
        return systemProperties;
    }
}
