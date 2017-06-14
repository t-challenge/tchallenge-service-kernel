package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class AccountStatusMapper extends EnumeratedEntityMapper<AccountStatus> {

    @Override
    protected AccountStatus enumeratedEntity() {
        return new AccountStatus();
    }
}
