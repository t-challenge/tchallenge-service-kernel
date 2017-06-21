package ru.tchallenge.service.kernel.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.conventions.httpmethod.DeleteHttpMethod;
import ru.tchallenge.service.kernel.conventions.httpmethod.GetHttpMethod;
import ru.tchallenge.service.kernel.conventions.httpmethod.PostHttpMethod;
import ru.tchallenge.service.kernel.conventions.security.AuthenticationNotRequired;
import ru.tchallenge.service.kernel.generic.GenericControllerBean;

@EndpointComponent("/authentication")
public class AuthenticationControllerBean extends GenericControllerBean {

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @PostHttpMethod
    @AuthenticationNotRequired
    public AuthenticationInfo create(@RequestBody final AuthenticationCreationInvoice invoice) {
        return authenticationFacade.create(invoice);
    }

    @GetHttpMethod
    public AuthenticationInfo get() {
        return authenticationFacade.get();
    }

    @DeleteHttpMethod
    public void remove(@RequestBody final AuthenticationRemovalInvoice invoice) {
        authenticationFacade.remove(invoice);
    }
}
