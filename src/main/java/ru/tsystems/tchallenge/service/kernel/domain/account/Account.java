package ru.tsystems.tchallenge.service.kernel.domain.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import ru.tsystems.tchallenge.service.kernel.domain.account.realm.AccountRealm;
import ru.tsystems.tchallenge.service.kernel.domain.account.status.AccountStatus;
import ru.tsystems.tchallenge.service.kernel.domain.shared.SequentialEntity;

@Entity
public class Account extends SequentialEntity {

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

    public Account() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public AccountRealm getRealm() {
        return realm;
    }

    public void setRealm(AccountRealm realm) {
        this.realm = realm;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getSecretHash() {
        return secretHash;
    }

    public void setSecretHash(String secretHash) {
        this.secretHash = secretHash;
    }
}
