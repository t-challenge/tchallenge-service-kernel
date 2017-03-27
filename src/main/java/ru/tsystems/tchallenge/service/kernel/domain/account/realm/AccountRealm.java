package ru.tsystems.tchallenge.service.kernel.domain.account.realm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountRealm {

    @Id
    @Column
    private String id;
}
