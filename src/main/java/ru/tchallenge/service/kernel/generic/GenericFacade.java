package ru.tchallenge.service.kernel.generic;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.security.authentication.AuthenticationContext;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

public abstract class GenericFacade extends GenericService {

    @Autowired
    private AuthenticationContext authenticationContext;

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    protected AuthenticationContext getAuthenticationContext() {
        return authenticationContext;
    }
}
