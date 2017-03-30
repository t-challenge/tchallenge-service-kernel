package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Lazy(false)
@Transactional
public abstract class GenericBootstrap<P> {

    @PostConstruct
    protected void bootstrap() {
        properties().stream().forEach(getService()::bootstrap);
    }

    protected abstract BootstrapAwareService<P> getService();

    protected Collection<P> properties() {
        Collection<P> collection = new ArrayList<>();
        collectProperties(collection);
        return collection;
    }

    protected abstract void collectProperties(Collection<P> properties);
}
