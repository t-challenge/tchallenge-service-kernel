package ru.tsystems.tchallenge.service.kernel.domain.shared;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface OrdinalEntityRepository<E extends OrdinalEntity> extends TimestampedEntityRepository<E, Long> {

}
