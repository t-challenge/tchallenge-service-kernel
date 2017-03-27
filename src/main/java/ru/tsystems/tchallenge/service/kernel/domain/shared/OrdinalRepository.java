package ru.tsystems.tchallenge.service.kernel.domain.shared;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface OrdinalRepository<E extends Ordinal> extends PersistentRepository<E, Long> {

    E findById(Long id);

    E save(E entity);
}
