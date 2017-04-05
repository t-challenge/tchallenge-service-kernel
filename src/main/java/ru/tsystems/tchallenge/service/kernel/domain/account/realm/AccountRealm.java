package ru.tsystems.tchallenge.service.kernel.domain.account.realm;

import javax.persistence.Entity;

import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@Entity
public class AccountRealm extends EnumeratedEntity {

    public AccountRealm(final String id) {
        super(id);
    }

    protected AccountRealm() {

    }
}
