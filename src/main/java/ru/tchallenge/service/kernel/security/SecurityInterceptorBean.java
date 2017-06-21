package ru.tchallenge.service.kernel.security;

import java.util.Collection;
import java.util.Enumeration;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;

import ru.tchallenge.service.kernel.conventions.components.RequestInterceptorComponent;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationService;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationContextConfigurer;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionProvider;

@RequestInterceptorComponent
public class SecurityInterceptorBean extends HandlerInterceptorAdapter {

    private Collection<EndpointMethodSignature> exclusions;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationContextConfigurer authenticationContextConfigurer;

    @Autowired
    private AccessValidationExceptionProvider accessValidationExceptionProvider;

    @Value("${tchallenge.security.token.header}")
    private String securityTokenHeader;

    @Value("${tchallenge.security.certificate.header}")
    private String securityPermkeyHeader;

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object object) throws Exception {
        if (authenticationRequired(request)) {
            authenticate(request);
        }
        return true;
    }

    @PostConstruct
    protected void onConstructed() {
        this.exclusions = ImmutableSet.of(
                new EndpointMethodSignature("POST", "/authentication")
        );
    }

    private void authenticate(final HttpServletRequest request) {
        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            final String name = headerNames.nextElement();
            if (name.equalsIgnoreCase(securityPermkeyHeader)) {
                authenticateByPermanentKeyId(request.getHeader(name));
                return;
            }
            if (name.equalsIgnoreCase(securityTokenHeader)) {
                authenticateByTokenId(request.getHeader(name));
                return;
            }
        }
        throw accessValidationExceptionProvider.unauthenticated();
    }

    private void authenticateByPermanentKeyId(final String permkeyId) {
        final AuthenticationInfo authentication = authenticationService.createByPermanentKeyId(permkeyId);
        authenticationContextConfigurer.setAuthentication(authentication);
    }

    private void authenticateByTokenId(final String tokenId) {
        final AuthenticationInfo authentication = authenticationService.createByTokenId(tokenId);
        authenticationContextConfigurer.setAuthentication(authentication);
    }

    private boolean authenticationRequired(final HttpServletRequest request) {
        final String method = request.getMethod();
        final String uri = request.getRequestURI();
        return !exclusions.contains(new EndpointMethodSignature(method, uri));
    }

    public static final class EndpointMethodSignature {

        private final String method;
        private final String uri;

        public EndpointMethodSignature(final String method, final String uri) {
            this.method = method;
            this.uri = uri;
        }

        @Override
        public boolean equals(final Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            final EndpointMethodSignature another = (EndpointMethodSignature) object;
            return Objects.equal(method, another.method) && Objects.equal(uri, another.uri);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(method, uri);
        }
    }
}
