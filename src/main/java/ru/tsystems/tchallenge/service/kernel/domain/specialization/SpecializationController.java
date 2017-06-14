package ru.tsystems.tchallenge.service.kernel.domain.specialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/specializations")
public class SpecializationController extends EnumeratedEntityController<Specialization> {

    @Autowired
    private EnumeratedEntityFacade<Specialization> facade;

    @Override
    protected EnumeratedEntityFacade<Specialization> getFacade() {
        return facade;
    }
}
