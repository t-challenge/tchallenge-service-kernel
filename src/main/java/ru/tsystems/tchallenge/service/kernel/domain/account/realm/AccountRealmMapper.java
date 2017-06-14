package ru.tsystems.tchallenge.service.kernel.domain.account.realm;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class AccountRealmMapper extends EnumeratedEntityMapper<AccountRealm> {

    @Override
    protected AccountRealm enumeratedEntity() {
        return new AccountRealm();
    }
}
