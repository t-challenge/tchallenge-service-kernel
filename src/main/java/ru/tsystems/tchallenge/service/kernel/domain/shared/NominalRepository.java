package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.util.Collection;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface NominalRepository<E extends Nominal> extends PersistentRepository<E, String> {

    Collection<E> findAll();

    E findById(String id);

    E save(E entity);
}
