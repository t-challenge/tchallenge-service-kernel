package ru.tchallenge.service.kernel.generic.repository;

import org.springframework.data.repository.NoRepositoryBean;

import ru.tchallenge.service.kernel.generic.entity.OrdinalEntity;

@NoRepositoryBean
public interface OrdinalEntityRepository<E extends OrdinalEntity> extends TimestampedEntityRepository<E, Long> {

}
