package ru.tsystems.tchallenge.service.kernel.domain.account.realm;

import org.springframework.data.repository.Repository;

public interface AccountRealmRepository extends Repository<AccountRealm, String> {

    AccountRealm findById(String id);

    AccountRealm save(AccountRealm realm);
}
