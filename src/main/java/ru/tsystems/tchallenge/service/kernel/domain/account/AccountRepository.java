package ru.tsystems.tchallenge.service.kernel.domain.account;

import ru.tsystems.tchallenge.service.kernel.domain.shared.OrdinalEntityRepository;

public interface AccountRepository extends OrdinalEntityRepository<Account> {

    Account findByLogin(String login);
}
