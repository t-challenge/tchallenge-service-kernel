package ru.tchallenge.service.kernel.security.authentication;

import ru.tchallenge.service.kernel.security.credential.EmailCredentialInvoice;
import ru.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;

public interface AuthenticationService {

    AuthenticationInfo create(SimpleLogonPairInvoice credential);

    AuthenticationInfo create(EmailCredentialInvoice credential);

    AuthenticationInfo create(String tokenId);
}
