package ru.tchallenge.service.kernel.domain.assignment;

import ru.tchallenge.service.kernel.generic.repository.CasualEntityRepository;

public interface AssignmentRepository extends CasualEntityRepository<Assignment> {

    Assignment findById(String id);
}
