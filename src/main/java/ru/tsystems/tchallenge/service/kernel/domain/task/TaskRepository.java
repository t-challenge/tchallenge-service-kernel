package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface TaskRepository extends OrdinalEntityRepository<Task> {

    Collection<Task> findAll();
}
