package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class NominalBootstrap<E extends Nominal> extends PersistentBootstrap<E, String> {

    @Autowired
    private NominalRepository<E> nominalRepository;

    @Override
    protected void collectEntities(Collection<E> entities) {
        ids().stream().forEach(id -> {
            E nominal = nominal();
            nominal.setId(id);
            entities.add(nominal);
        });
    }

    protected abstract void collectIds(Collection<String> ids);

    protected abstract E nominal();

    @Override
    protected NominalRepository<E> getRepository() {
        return nominalRepository;
    }

    private Collection<String> ids() {
        Collection<String> result = new ArrayList<>();
        collectIds(result);
        return result;
    }
}
