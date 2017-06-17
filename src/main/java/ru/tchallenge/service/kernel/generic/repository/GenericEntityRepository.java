package ru.tchallenge.service.kernel.generic.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import ru.tchallenge.service.kernel.generic.entity.GenericEntity;

@NoRepositoryBean
public interface GenericEntityRepository<E extends GenericEntity<ID>, ID extends Serializable> extends Repository<E, ID> {

    E findById(ID id);

    E save(E entity);
}
