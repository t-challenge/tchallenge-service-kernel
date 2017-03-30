package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.domain.shared.EnumeratedEntity;

@Entity
public class AccountStatus extends EnumeratedEntity {

    public AccountStatus(String id) {
        super(id);
    }

    protected AccountStatus() {

    }
}
