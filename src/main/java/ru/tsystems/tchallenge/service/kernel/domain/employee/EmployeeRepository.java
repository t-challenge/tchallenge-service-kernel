package ru.tsystems.tchallenge.service.kernel.domain.employee;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface EmployeeRepository extends OrdinalEntityRepository<Employee> {

    Collection<Employee> findAll();

    @Query("SELECT e FROM Employee AS e WHERE e.account.login = :login")
    Employee findByLogin(@Param("login") String login);
}
