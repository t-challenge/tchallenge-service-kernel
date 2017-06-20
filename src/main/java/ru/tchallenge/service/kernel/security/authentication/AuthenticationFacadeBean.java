package ru.tchallenge.service.kernel.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.FacadeServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericFacade;
import ru.tchallenge.service.kernel.security.token.TokenInfo;
import ru.tchallenge.service.kernel.security.token.TokenService;

@FacadeServiceComponent
public class AuthenticationFacadeBean extends GenericFacade implements AuthenticationFacade {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private TokenService tokenService;

    @Override
    public AuthenticationInfo create(final AuthenticationCreationInvoice invoice) {
        ensureCreationInvoice(invoice);
        final String rescueId = invoice.getRescueId();
        if (rescueId != null) {
            return authenticationService.createByRescueId(rescueId);
        }
        final String login = invoice.getLogin();
        final String password = invoice.getPassword();
        return authenticationService.createByLoginPasswordPair(login, password);
    }

    @Override
    public AuthenticationInfo get() {
        return authentication();
    }

    @Override
    public void remove(final AuthenticationRemovalInvoice invoice) {
        final TokenInfo token = authentication().getToken();
        if (token == null) {
            // TODO: throw specific exception
            throw new RuntimeException("authentication removal is unavailable");
        }
        if (shouldRemoveAll(invoice)) {
            tokenService.removeByLogin(token.getLogin());
        } else {
            tokenService.removeById(token.getId());
        }
    }

    private AuthenticationInfo authentication() {
        final AuthenticationInfo result = getAuthenticationContext().getAuthentication();
        if (result == null) {
            // TODO: throw authentication exception
            throw new RuntimeException("no authentication");
        }
        return result;
    }

    private void ensureCreationInvoice(AuthenticationCreationInvoice invoice) {
        if (invoice == null) {
            // TODO: throw specific exception
            throw new RuntimeException("invoice is null");
        }
        final Boolean rescueMode = invoice.getRescueMode();
        final String rescueId = invoice.getRescueId();
        if (rescueMode != null && rescueMode && rescueId == null) {
            // TODO: throw specific exception
            throw new RuntimeException("rescue ID is null");
        }
        if (invoice.getLogin() == null) {
            // TODO: throw specific exception
            throw new RuntimeException("login is null");
        }
        if (invoice.getPassword() == null) {
            // TODO: throw specific exception
            throw new RuntimeException("password is null");
        }
    }

    private boolean shouldRemoveAll(final AuthenticationRemovalInvoice invoice) {
        return invoice != null && invoice.getAll() != null && invoice.getAll();
    }
}
