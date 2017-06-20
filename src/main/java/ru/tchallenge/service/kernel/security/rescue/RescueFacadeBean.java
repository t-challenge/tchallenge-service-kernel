package ru.tchallenge.service.kernel.security.rescue;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.FacadeServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericFacade;

@FacadeServiceComponent
public class RescueFacadeBean extends GenericFacade implements RescueFacade {

    @Autowired
    private RescueService rescueService;

    @Override
    public void create(final RescueInvoice invoice) {
        if (invoice == null || invoice.getEmail() == null) {
            // TODO: throw specific exception
            throw new RuntimeException("invoice is corrupted");
        }
        rescueService.create(invoice);
    }
}
