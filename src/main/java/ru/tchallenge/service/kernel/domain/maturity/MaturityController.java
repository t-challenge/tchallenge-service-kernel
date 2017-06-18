package ru.tchallenge.service.kernel.domain.maturity;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/maturities")
public class MaturityController extends EnumeratedEntityController<Maturity> {

    @Autowired
    private EnumeratedEntityFacade<Maturity> facade;

    @Override
    protected EnumeratedEntityFacade<Maturity> getFacade() {
        return facade;
    }
}
