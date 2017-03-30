package ru.tsystems.tchallenge.service.kernel.domain.shared;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CasualEntityRepository<E extends CasualEntity> extends TimestampedEntityRepository<E, String> {

}
