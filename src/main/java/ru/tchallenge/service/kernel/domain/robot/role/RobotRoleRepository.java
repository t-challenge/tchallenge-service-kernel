package ru.tchallenge.service.kernel.domain.robot.role;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

public interface RobotRoleRepository extends EnumeratedEntityRepository<RobotRole> {

    @Query("SELECT r FROM RobotRole r WHERE r.id IN :ids")
    Collection<RobotRole> findAllById(@Param("ids") Collection<String> ids);
}
