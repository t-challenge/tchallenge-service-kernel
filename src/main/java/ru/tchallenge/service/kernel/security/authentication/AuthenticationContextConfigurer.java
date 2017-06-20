package ru.tchallenge.service.kernel.security.authentication;

public interface AuthenticationContextConfigurer extends AuthenticationContext {

    void setAuthentication(AuthenticationInfo authentication);
}
