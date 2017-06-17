package ru.tchallenge.service.kernel.security;

import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;

public interface SecurityContextConfigurer extends SecurityContext {

    void setAuthentication(AuthenticationInfo authentication);
}
