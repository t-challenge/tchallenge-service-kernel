package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface PersistentRepository<E extends Persistent, K extends Serializable> extends Repository<E, K> {

    E findById(K id);

    E save(E entity);
}
