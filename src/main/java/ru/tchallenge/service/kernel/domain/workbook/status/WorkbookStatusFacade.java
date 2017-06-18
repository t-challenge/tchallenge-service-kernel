package ru.tchallenge.service.kernel.domain.workbook.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.ServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@ServiceComponent
public class WorkbookStatusFacade extends EnumeratedEntityFacade<WorkbookStatus> {

    @Autowired
    private EnumeratedEntityMapper<WorkbookStatus> mapper;

    @Autowired
    private EnumeratedEntityRepository<WorkbookStatus> repository;

    @Override
    protected EnumeratedEntityMapper<WorkbookStatus> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<WorkbookStatus> getRepository() {
        return repository;
    }
}
