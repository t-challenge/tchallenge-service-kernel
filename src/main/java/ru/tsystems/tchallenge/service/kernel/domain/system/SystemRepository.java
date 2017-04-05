package ru.tsystems.tchallenge.service.kernel.domain.system;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface SystemRepository extends OrdinalEntityRepository<System> {

    Collection<System> findAll();

    @Query("SELECT s FROM System AS s WHERE s.account.login = :login")
    System findByLogin(@Param("login") String login);
}
