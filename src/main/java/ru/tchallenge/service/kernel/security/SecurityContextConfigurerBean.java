package ru.tchallenge.service.kernel.security;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import ru.tchallenge.service.kernel.generic.GenericContext;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;

@Component
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.INTERFACES)
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
