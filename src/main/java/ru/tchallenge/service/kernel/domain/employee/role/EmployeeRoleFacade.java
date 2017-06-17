package ru.tchallenge.service.kernel.domain.employee.role;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class EmployeeRoleFacade extends EnumeratedEntityFacade<EmployeeRole> {

    @Autowired
    private EnumeratedEntityMapper<EmployeeRole> mapper;

    @Autowired
    private EnumeratedEntityRepository<EmployeeRole> repository;

    @Override
    protected EnumeratedEntityMapper<EmployeeRole> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<EmployeeRole> getRepository() {
        return repository;
    }
}
