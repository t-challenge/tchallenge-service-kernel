package ru.tchallenge.service.kernel.generic;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.security.authentication.AuthenticationContext;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionProvider;

public abstract class GenericFacade extends GenericService {

    @Autowired
    private AuthenticationContext authenticationContext;

    @Autowired
    private AccessValidationExceptionProvider accessValidationExceptionProvider;

    protected AuthenticationContext getAuthenticationContext() {
        return authenticationContext;
    }
}
