package ru.tchallenge.service.kernel.domain.account.realm;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class AccountRealmMapper extends EnumeratedEntityMapper<AccountRealm> {

    @Override
    protected AccountRealm enumeratedEntity() {
        return new AccountRealm();
    }
}
