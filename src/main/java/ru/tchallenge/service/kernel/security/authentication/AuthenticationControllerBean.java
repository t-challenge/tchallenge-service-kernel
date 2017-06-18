package ru.tchallenge.service.kernel.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.GenericControllerBean;
import ru.tchallenge.service.kernel.security.credential.SimpleLogonPairInvoice;
import ru.tchallenge.service.kernel.security.credential.SimpleLogonPairValidator;
import ru.tchallenge.service.kernel.security.token.TokenFacade;

@EndpointComponent("/authentication")
public class AuthenticationControllerBean extends GenericControllerBean {

    @Autowired
    private TokenFacade tokenFacade;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private SimpleLogonPairValidator simpleLogonPairValidator;

    @RequestMapping(method = RequestMethod.POST)
    public AuthenticationInfo create(@RequestBody final SimpleLogonPairInvoice credential) {
        ensureCredential(credential);
        return authenticate(credential);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeAll() {
        tokenFacade.removeAll();
    }

    @RequestMapping(path = "/current", method = RequestMethod.DELETE)
    public void removeCurrent() {
        tokenFacade.removeCurrent();
    }

    private AuthenticationInfo authenticate(final SimpleLogonPairInvoice pair) {
        return authenticationService.create(pair);
    }

    private SimpleLogonPairInvoice ensureCredential(final SimpleLogonPairInvoice credential) {
        return simpleLogonPairValidator.ensure(credential);
    }
}
