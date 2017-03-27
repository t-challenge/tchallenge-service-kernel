package ru.tsystems.tchallenge.service.kernel.domain.account.status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountStatus {

    @Id
    @Column
    private String id;
}
