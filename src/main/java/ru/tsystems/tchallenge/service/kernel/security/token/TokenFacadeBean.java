package ru.tsystems.tchallenge.service.kernel.security.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationService;
import ru.tsystems.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;
import ru.tsystems.tchallenge.service.kernel.security.credential.SimpleLogonPairValidator;

@Service
@Transactional(readOnly = true)
public class TokenFacadeBean extends GenericFacade implements TokenFacade {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SimpleLogonPairValidator simpleLogonPairValidator;

    @Override
    public TokenInfo create(final SimpleLogonPairInvoice credential) {
        ensureCredential(credential);
        return authenticate(credential).getToken();
    }

    @Override
    public void removeAll() {
        tokenService.removeByLogin(token().getLogin());
    }

    @Override
    public void removeCurrent() {
        tokenService.removeById(token().getId());
    }

    private AuthenticationInfo authenticate(final SimpleLogonPairInvoice pair) {
        return authenticationService.create(pair);
    }

    private SimpleLogonPairInvoice ensureCredential(final SimpleLogonPairInvoice credential) {
        return simpleLogonPairValidator.ensure(credential);
    }

    private TokenInfo token() {
        return null;
    }
}
