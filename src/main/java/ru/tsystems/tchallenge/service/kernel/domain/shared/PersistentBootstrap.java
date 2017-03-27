package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Lazy(false)
@Transactional
public abstract class PersistentBootstrap<E extends Persistent, K extends Serializable> {

    @PostConstruct
    public void init() {
        getEntities().stream().forEach(getRepository()::save);
    }

    protected abstract void collectEntities(Collection<E> entities);

    protected Collection<E> getEntities() {
        Collection<E> entities = new ArrayList<>();
        collectEntities(entities);
        return entities;
    }

    protected abstract PersistentRepository<E, K> getRepository();
}
