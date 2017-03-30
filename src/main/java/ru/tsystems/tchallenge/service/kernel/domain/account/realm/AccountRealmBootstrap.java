package ru.tsystems.tchallenge.service.kernel.domain.account.realm;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.domain.shared.BootstrapAwareService;
import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityBootstrap;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountRealmBootstrap extends EnumeratedEntityBootstrap {

    @Autowired
    private AccountRealmService accountRealmService;

    @Override
    protected BootstrapAwareService<String> getService() {
        return accountRealmService;
    }

    @Override
    protected void collectProperties(Collection<String> properties) {
        properties.add("CANDIDATE");
        properties.add("EMPLOYEE");
        properties.add("SYSTEM");
    }
}
