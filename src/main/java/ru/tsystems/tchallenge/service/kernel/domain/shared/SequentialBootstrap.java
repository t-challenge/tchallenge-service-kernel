package ru.tsystems.tchallenge.service.kernel.domain.shared;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class SequentialBootstrap<E extends Sequential> extends PersistentBootstrap<E, Long> {

    @Autowired
    private SequentialRepository<E> sequentialRepository;

    @Override
    protected SequentialRepository<E> getRepository() {
        return sequentialRepository;
    }
}
