package ru.tsystems.tchallenge.service.kernel.domain.account;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealm;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatus;

@Entity
public class Account {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String email;

    @Column
    private String login;

    @ManyToOne
    private AccountRealm realm;

    @ManyToOne
    private AccountStatus status;

    @Column
    private String secretHash;

    @Column
    private Instant createdAt;

    @Column
    private Instant modifiedAt;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public AccountRealm getRealm() {
        return realm;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public String getSecretHash() {
        return secretHash;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }

    @PrePersist
    protected void onCreated() {
        this.createdAt = Instant.now();
        this.modifiedAt = Instant.now();
    }

    @PreUpdate
    protected void onModified() {
        this.modifiedAt = Instant.now();
    }
}
