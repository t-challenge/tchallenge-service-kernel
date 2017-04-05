package ru.tsystems.tchallenge.service.kernel.security;

import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;

public interface SecurityContext {

    AuthenticationInfo getAuthentication();
}
