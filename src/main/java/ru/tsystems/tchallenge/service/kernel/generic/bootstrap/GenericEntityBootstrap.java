package ru.tsystems.tchallenge.service.kernel.generic.bootstrap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.generic.entity.GenericEntity;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@Lazy(false)
@Transactional
public abstract class GenericEntityBootstrap<E extends GenericEntity<ID>, ID extends Serializable> {

    @PostConstruct
    protected void bootstrap() {
        entities().stream().forEach(getRepository()::save);
    }

    protected Collection<E> entities() {
        Collection<E> collection = new ArrayList<>();
        collectEntities(collection);
        return collection;
    }

    protected abstract void collectEntities(final Collection<E> entities);

    protected abstract GenericEntityRepository<E, ID> getRepository();
}
