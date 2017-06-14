package ru.tsystems.tchallenge.service.kernel.domain.assignment.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class AssignmentStatusFacade extends EnumeratedEntityFacade<AssignmentStatus> {

    @Autowired
    private EnumeratedEntityMapper<AssignmentStatus> mapper;

    @Autowired
    private EnumeratedEntityRepository<AssignmentStatus> repository;

    @Override
    protected EnumeratedEntityMapper<AssignmentStatus> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<AssignmentStatus> getRepository() {
        return repository;
    }
}
