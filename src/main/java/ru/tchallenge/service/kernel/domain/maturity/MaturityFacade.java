package ru.tchallenge.service.kernel.domain.maturity;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class MaturityFacade extends EnumeratedEntityFacade<Maturity> {

    @Autowired
    private EnumeratedEntityMapper<Maturity> mapper;

    @Autowired
    private EnumeratedEntityRepository<Maturity> repository;

    @Override
    protected EnumeratedEntityMapper<Maturity> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<Maturity> getRepository() {
        return repository;
    }
}
