package ru.tchallenge.service.kernel.security;

import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;

public interface SecurityContext {

    AuthenticationInfo getAuthentication();
}
