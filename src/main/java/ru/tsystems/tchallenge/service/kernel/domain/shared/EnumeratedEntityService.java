package ru.tsystems.tchallenge.service.kernel.domain.shared;

public abstract class EnumeratedEntityService<E extends EnumeratedEntity> extends GenericService implements BootstrapAwareService<String> {

    @Override
    public String bootstrap(String id) {
        return getRepository().save(enumerated(id)).getId();
    }

    protected abstract EnumeratedEntityRepository<E> getRepository();

    protected abstract E enumerated(String id);
}
