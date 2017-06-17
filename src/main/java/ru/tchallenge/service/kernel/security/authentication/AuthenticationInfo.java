package ru.tchallenge.service.kernel.security.authentication;

import ru.tchallenge.service.kernel.domain.account.AccountInfo;
import ru.tchallenge.service.kernel.generic.GenericInfo;
import ru.tchallenge.service.kernel.security.token.TokenInfo;

public final class AuthenticationInfo extends GenericInfo {

    private final AccountInfo account;
    private final TokenInfo token;

    public AuthenticationInfo(final AccountInfo account,
                              final TokenInfo token) {
        this.account = account;
        this.token = token;
    }

    public AccountInfo getAccount() {
        return account;
    }

    public TokenInfo getToken() {
        return token;
    }
}
