package ru.tsystems.tchallenge.service.kernel.domain.shared;

public interface BootstrapAwareService<P> {

    Object bootstrap(P properties);
}
