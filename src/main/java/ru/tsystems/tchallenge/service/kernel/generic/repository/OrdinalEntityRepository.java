package ru.tsystems.tchallenge.service.kernel.generic.repository;

import org.springframework.data.repository.NoRepositoryBean;

import ru.tsystems.tchallenge.service.kernel.generic.entity.OrdinalEntity;

@NoRepositoryBean
public interface OrdinalEntityRepository<E extends OrdinalEntity> extends TimestampedEntityRepository<E, Long> {

}
