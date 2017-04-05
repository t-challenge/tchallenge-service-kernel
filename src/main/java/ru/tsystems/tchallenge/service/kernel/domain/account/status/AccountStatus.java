package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class AccountStatus extends EnumeratedEntity {

    public AccountStatus(final String id) {
        super(id);
    }

    protected AccountStatus() {

    }
}
