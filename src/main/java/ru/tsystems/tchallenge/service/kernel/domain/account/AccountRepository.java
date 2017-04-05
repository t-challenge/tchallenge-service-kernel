package ru.tsystems.tchallenge.service.kernel.domain.account;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface AccountRepository extends OrdinalEntityRepository<Account> {

    Account findByEmail(String email);

    Account findByLogin(String login);
}
