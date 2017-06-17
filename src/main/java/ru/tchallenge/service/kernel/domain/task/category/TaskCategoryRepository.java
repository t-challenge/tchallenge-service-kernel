package ru.tchallenge.service.kernel.domain.task.category;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

public interface TaskCategoryRepository extends EnumeratedEntityRepository<TaskCategory> {

    @Query("SELECT c FROM TaskCategory AS c WHERE c.id IN :ids")
    Collection<TaskCategory> findAllById(@Param("ids") Collection<String> ids);
}
