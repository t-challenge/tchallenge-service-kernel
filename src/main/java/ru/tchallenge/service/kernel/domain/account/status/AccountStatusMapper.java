package ru.tchallenge.service.kernel.domain.account.status;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class AccountStatusMapper extends EnumeratedEntityMapper<AccountStatus> {

    @Override
    protected AccountStatus enumeratedEntity() {
        return new AccountStatus();
    }
}
