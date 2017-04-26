package ru.tsystems.tchallenge.service.kernel.domain.assignment;

import ru.tsystems.tchallenge.service.kernel.generic.repository.CasualEntityRepository;

public interface AssignmentRepository extends CasualEntityRepository<Assignment> {

    Assignment findById(String id);
}
