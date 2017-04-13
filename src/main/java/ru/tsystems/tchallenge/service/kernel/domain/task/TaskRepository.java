package ru.tsystems.tchallenge.service.kernel.domain.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface TaskRepository extends OrdinalEntityRepository<Task> {

    @Query("SELECT t FROM Task AS t")
    Page<Task> findPage(Pageable pageable);
}
