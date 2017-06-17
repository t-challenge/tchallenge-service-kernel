package ru.tchallenge.service.kernel.domain.maturity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/maturities")
public class MaturityController extends EnumeratedEntityController<Maturity> {

    @Autowired
    private EnumeratedEntityFacade<Maturity> facade;

    @Override
    protected EnumeratedEntityFacade<Maturity> getFacade() {
        return facade;
    }
}
