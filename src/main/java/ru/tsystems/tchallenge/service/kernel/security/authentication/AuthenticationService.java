package ru.tsystems.tchallenge.service.kernel.security.authentication;

import ru.tsystems.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;

public interface AuthenticationService {

    AuthenticationInfo create(SimpleLogonPairInvoice credential);

    AuthenticationInfo create(String tokenId);
}
