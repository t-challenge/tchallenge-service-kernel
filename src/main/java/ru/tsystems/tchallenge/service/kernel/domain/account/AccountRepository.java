package ru.tsystems.tchallenge.service.kernel.domain.account;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface AccountRepository extends OrdinalEntityRepository<Account> {

    Collection<Account> findAll();

    Account findByLogin(String login);
}
