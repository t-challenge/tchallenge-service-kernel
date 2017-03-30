package ru.tsystems.tchallenge.service.kernel.domain.shared;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TimestampedEntityRepository<E extends TimestampedEntity<ID>, ID extends Serializable> extends BaseEntityRepository<E, ID> {

}
