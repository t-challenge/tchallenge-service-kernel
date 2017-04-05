package ru.tsystems.tchallenge.service.kernel.domain.system.role;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

public interface SystemRoleRepository extends EnumeratedEntityRepository<SystemRole> {

    @Query("SELECT r FROM SystemRole r WHERE r.id IN :ids")
    Collection<SystemRole> findAllById(@Param("ids") Collection<String> ids);
}
