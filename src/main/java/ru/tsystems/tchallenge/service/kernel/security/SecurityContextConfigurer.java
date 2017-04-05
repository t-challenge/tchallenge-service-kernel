package ru.tsystems.tchallenge.service.kernel.security;

import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;

public interface SecurityContextConfigurer extends SecurityContext {

    void setAuthentication(AuthenticationInfo authentication);
}
