package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.domain.shared.BootstrapAwareService;
import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntityBootstrap;

@Component
public class AccountStatusBootstrap extends EnumeratedEntityBootstrap {

    @Autowired
    private AccountStatusService accountStatusService;

    @Override
    protected BootstrapAwareService<String> getService() {
        return accountStatusService;
    }

    @Override
    protected void collectProperties(Collection<String> properties) {
        properties.add("CREATED");
        properties.add("APPROVED");
        properties.add("SUSPENDED");
        properties.add("BLOCKED");
    }
}
