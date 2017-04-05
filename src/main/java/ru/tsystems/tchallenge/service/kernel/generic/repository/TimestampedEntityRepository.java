package ru.tsystems.tchallenge.service.kernel.generic.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import ru.tsystems.tchallenge.service.kernel.generic.entity.TimestampedEntity;

@NoRepositoryBean
public interface TimestampedEntityRepository<E extends TimestampedEntity<ID>, ID extends Serializable> extends GenericEntityRepository<E, ID> {

}
