package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.domain.shared.NominalBootstrap;

@Component
@Transactional
public class AccountStatusBootstrap extends NominalBootstrap<AccountStatus> {

    @Override
    protected void collectIds(Collection<String> ids) {
        ids.add("CREATED");
        ids.add("APPROVED");
        ids.add("SUSPENDED");
        ids.add("BLOCKED");
    }

    @Override
    protected AccountStatus nominal() {
        return new AccountStatus();
    }
}
