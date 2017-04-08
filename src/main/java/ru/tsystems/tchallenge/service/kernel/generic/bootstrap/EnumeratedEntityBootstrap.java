package ru.tsystems.tchallenge.service.kernel.generic.bootstrap;

import java.util.ArrayList;
import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

public abstract class EnumeratedEntityBootstrap<E extends EnumeratedEntity> extends GenericEntityBootstrap<E, String> {

    @Override
    protected void collectEntities(final Collection<E> entities) {
        ids().stream().map(this::enumerated).forEach(entities::add);
    }

    protected Collection<String> ids() {
        Collection<String> collection = new ArrayList<>();
        collectIds(collection);
        return collection;
    }

    protected abstract void collectIds(final Collection<String> ids);

    protected abstract E enumerated(final String id);
}
