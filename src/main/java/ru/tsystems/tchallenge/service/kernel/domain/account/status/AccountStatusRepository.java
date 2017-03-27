package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import org.springframework.data.repository.Repository;

public interface AccountStatusRepository extends Repository<AccountStatus, String> {

    AccountStatus findById(String id);

    AccountStatus save(AccountStatus status);
}
