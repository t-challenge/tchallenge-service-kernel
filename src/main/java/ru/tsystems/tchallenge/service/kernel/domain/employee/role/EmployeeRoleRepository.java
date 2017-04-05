package ru.tsystems.tchallenge.service.kernel.domain.employee.role;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

public interface EmployeeRoleRepository extends EnumeratedEntityRepository<EmployeeRole> {

    @Query("SELECT r FROM EmployeeRole r WHERE r.id IN :ids")
    Collection<EmployeeRole> findAllById(@Param("ids") Collection<String> ids);
}
