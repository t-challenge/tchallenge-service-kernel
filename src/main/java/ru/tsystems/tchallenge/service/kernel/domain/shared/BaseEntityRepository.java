package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseEntityRepository<E extends BaseEntity<ID>, ID extends Serializable> extends Repository<E, ID> {

    E findById(ID id);

    E save(E entity);
}
