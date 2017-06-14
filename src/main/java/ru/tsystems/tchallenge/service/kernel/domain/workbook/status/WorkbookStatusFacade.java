package ru.tsystems.tchallenge.service.kernel.domain.workbook.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
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
