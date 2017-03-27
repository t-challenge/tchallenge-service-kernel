package ru.tsystems.tchallenge.service.kernel.domain.account;

import ru.tsystems.tchallenge.service.kernel.domain.shared.SequentialRepository;

public interface AccountRepository extends SequentialRepository<Account> {

    Account findByEmail(String email);

    Account findByLogin(String login);
}
