package ru.tchallenge.service.kernel.domain.specialization;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class SpecializationFacade extends EnumeratedEntityFacade<Specialization> {

    @Autowired
    private EnumeratedEntityMapper<Specialization> mapper;

    @Autowired
    private EnumeratedEntityRepository<Specialization> repository;

    @Override
    protected EnumeratedEntityMapper<Specialization> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<Specialization> getRepository() {
        return repository;
    }
}
