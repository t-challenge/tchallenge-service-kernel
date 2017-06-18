package ru.tchallenge.service.kernel.domain.specialization;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/specializations")
public class SpecializationController extends EnumeratedEntityController<Specialization> {

    @Autowired
    private EnumeratedEntityFacade<Specialization> facade;

    @Override
    protected EnumeratedEntityFacade<Specialization> getFacade() {
        return facade;
    }
}
