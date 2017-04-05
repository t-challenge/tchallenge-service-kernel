package ru.tsystems.tchallenge.service.kernel.security.token;

import ru.tsystems.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;

public interface TokenFacade {

    TokenInfo create(SimpleLogonPairInvoice credential);

    void removeAll();

    void removeCurrent();
}
