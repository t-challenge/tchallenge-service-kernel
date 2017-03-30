package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.util.Collection;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EnumeratedEntityRepository<E extends EnumeratedEntity> extends BaseEntityRepository<E, String> {

    Collection<E> findAll();
}
