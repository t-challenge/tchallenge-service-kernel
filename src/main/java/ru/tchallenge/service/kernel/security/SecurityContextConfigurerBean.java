package ru.tchallenge.service.kernel.security;

import ru.tchallenge.service.kernel.conventions.components.RequestContextComponent;
import ru.tchallenge.service.kernel.generic.GenericContext;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;

@RequestContextComponent
public class SecurityContextConfigurerBean extends GenericContext implements SecurityContextConfigurer {

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
