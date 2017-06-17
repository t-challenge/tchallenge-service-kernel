package ru.tchallenge.service.kernel.domain.account;

import java.util.Collection;

import ru.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface AccountRepository extends OrdinalEntityRepository<Account> {

    Collection<Account> findAll();

    Account findByEmail(String email);

    Account findByLogin(String login);
}
