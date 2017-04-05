package ru.tsystems.tchallenge.service.kernel.generic.repository;

import org.springframework.data.repository.NoRepositoryBean;

import ru.tsystems.tchallenge.service.kernel.generic.entity.CasualEntity;

@NoRepositoryBean
public interface CasualEntityRepository<E extends CasualEntity> extends TimestampedEntityRepository<E, String> {

}
