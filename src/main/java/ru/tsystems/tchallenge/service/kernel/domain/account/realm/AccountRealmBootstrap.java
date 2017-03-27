package ru.tsystems.tchallenge.service.kernel.domain.account.realm;

import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.domain.shared.NominalBootstrap;

@Component
@Transactional
public class AccountRealmBootstrap extends NominalBootstrap<AccountRealm> {

    @Override
    protected void collectIds(Collection<String> ids) {
        ids.add("CANDIDATE");
        ids.add("EMPLOYEE");
        ids.add("ROBOT");
    }

    @Override
    protected AccountRealm nominal() {
        return new AccountRealm();
    }
}
