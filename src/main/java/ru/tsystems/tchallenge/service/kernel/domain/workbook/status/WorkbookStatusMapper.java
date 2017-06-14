package ru.tsystems.tchallenge.service.kernel.domain.workbook.status;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class WorkbookStatusMapper extends EnumeratedEntityMapper<WorkbookStatus> {

    @Override
    protected WorkbookStatus enumeratedEntity() {
        return new WorkbookStatus();
    }
}
