package ru.tsystems.tchallenge.service.kernel.security;

import org.springframework.stereotype.Component;

import ru.tsystems.tchallenge.service.kernel.generic.GenericContext;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;

@Component
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
