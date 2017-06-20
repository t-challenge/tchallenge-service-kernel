package ru.tchallenge.service.kernel.security;

import java.util.Enumeration;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ru.tchallenge.service.kernel.conventions.components.RequestInterceptorComponent;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationService;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationContextConfigurer;

@RequestInterceptorComponent
public class SecurityInterceptorBean extends HandlerInterceptorAdapter {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationContextConfigurer authenticationContextConfigurer;

    @Value("${tchallenge.security.token.header}")
    private String securityTokenHeader;

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object object) throws Exception {
        final Optional<String> tokenId = parseTokenId(request);
        if (tokenId.isPresent()) {
            final AuthenticationInfo authentication = authenticate(tokenId.get());
            authenticationContextConfigurer.setAuthentication(authentication);
        }
        return true;
    }

    private AuthenticationInfo authenticate(final String tokenId) {
        return authenticationService.createByTokenId(tokenId);
    }

    private Optional<String> parseTokenId(final HttpServletRequest request) {
        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            final String headerName = headerNames.nextElement();
            if (headerName.equalsIgnoreCase(securityTokenHeader)) {
                return Optional.of(request.getHeader(headerName));
            }
        }
        return Optional.empty();
    }
}
