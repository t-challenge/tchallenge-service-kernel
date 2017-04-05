package ru.tsystems.tchallenge.service.kernel.generic.repository;

import java.util.Collection;

import org.springframework.data.repository.NoRepositoryBean;

import ru.tsystems.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@NoRepositoryBean
public interface EnumeratedEntityRepository<E extends EnumeratedEntity> extends GenericEntityRepository<E, String> {

    Collection<E> findAll();
}
