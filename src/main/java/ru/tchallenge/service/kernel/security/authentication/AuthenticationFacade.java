package ru.tchallenge.service.kernel.security.authentication;

public interface AuthenticationFacade {

    AuthenticationInfo create(AuthenticationCreationInvoice invoice);

    AuthenticationInfo get();

    void remove(AuthenticationRemovalInvoice invoice);
}
