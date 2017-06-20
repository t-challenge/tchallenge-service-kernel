package ru.tchallenge.service.kernel.security.authentication;

import ru.tchallenge.service.kernel.conventions.components.RequestContextComponent;
import ru.tchallenge.service.kernel.generic.GenericContext;

@RequestContextComponent
public class AuthenticationContextConfigurerBean extends GenericContext implements AuthenticationContextConfigurer {

    private AuthenticationInfo authentication;

    @Override
    public AuthenticationInfo getAuthentication() {
        return authentication;
    }

    @Override
    public void setAuthentication(final AuthenticationInfo authentication) {
        this.authentication = authentication;
    }
}
