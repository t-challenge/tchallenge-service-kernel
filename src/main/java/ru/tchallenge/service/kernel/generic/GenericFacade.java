package ru.tchallenge.service.kernel.generic;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.security.SecurityContext;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

public abstract class GenericFacade extends GenericService {

    @Autowired
    private SecurityContext securityContext;

    @Autowired
    private AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    protected SecurityContext getSecurityContext() {
        return securityContext;
    }
}
