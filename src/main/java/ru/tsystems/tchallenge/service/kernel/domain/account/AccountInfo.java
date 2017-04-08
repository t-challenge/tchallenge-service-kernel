package ru.tsystems.tchallenge.service.kernel.domain.account;

import java.time.Instant;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class AccountInfo extends GenericInfo {

    private final String email;
    private final String login;
    private final String realm;
    private final String status;
    private final Instant createdAt;
    private final Instant modifiedAt;

    public AccountInfo(final String email,
                       final String login,
                       final String realm,
                       final String status,
                       final Instant createdAt,
                       final Instant modifiedAt) {
        this.email = email;
        this.login = login;
        this.realm = realm;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getRealm() {
        return realm;
    }

    public String getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }
}
