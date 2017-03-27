package ru.tsystems.tchallenge.service.kernel.domain.shared;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CasualRepository<E extends Casual> extends PersistentRepository<E, String> {

    E findById(String id);

    E save(E entity);
}
