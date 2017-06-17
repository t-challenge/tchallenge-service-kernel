package ru.tchallenge.service.kernel.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationService;

@Service
public class SecurityInterceptorBean extends HandlerInterceptorAdapter {

    private final String authTokenHeader = "T-Challenge-Security-Token";

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private SecurityContextConfigurer securityContextConfigurer;

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object object) throws Exception {
        final String token = request.getHeader(authTokenHeader);
        if (token != null) {
            securityContextConfigurer.setAuthentication(authenticate(token));
        }
        return true;
    }

    private AuthenticationInfo authenticate(final String tokenId) {
        return authenticationService.create(tokenId);
    }
}
