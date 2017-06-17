package ru.tchallenge.service.kernel.security.token;

import ru.tchallenge.service.kernel.security.credential.EmailCredentialInvoice;
import ru.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;

public interface TokenFacade {

    TokenInfo create(SimpleLogonPairInvoice credential);

    void createAndMail(EmailCredentialInvoice credential);

    void removeAll();

    void removeCurrent();
}
