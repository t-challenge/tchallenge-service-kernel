package ru.tchallenge.service.kernel.security.rescue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.conventions.httpmethod.PostHttpMethod;
import ru.tchallenge.service.kernel.conventions.security.AuthenticationNotRequired;
import ru.tchallenge.service.kernel.generic.GenericControllerBean;

@EndpointComponent("/rescues")
public class RescueControllerBean extends GenericControllerBean {

    @Autowired
    private RescueFacade rescueFacade;

    @PostHttpMethod
    @AuthenticationNotRequired
    public void create(@RequestBody final RescueInvoice invoice) {
        rescueFacade.create(invoice);
    }
}
