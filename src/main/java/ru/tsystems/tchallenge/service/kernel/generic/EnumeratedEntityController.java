package ru.tsystems.tchallenge.service.kernel.generic;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

public abstract class EnumeratedEntityController<T extends EnumeratedEntity> extends GenericController {

    @RequestMapping(method = RequestMethod.GET)
    public Collection<EnumeratedInfo> getAll() {
        return getFacade().getAll();
    }

    protected abstract EnumeratedEntityFacade<T> getFacade();
}
