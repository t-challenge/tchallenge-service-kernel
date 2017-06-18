package ru.tchallenge.service.kernel.domain.workbook.status;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class WorkbookStatusMapper extends EnumeratedEntityMapper<WorkbookStatus> {

    @Override
    protected WorkbookStatus enumeratedEntity() {
        return new WorkbookStatus();
    }
}
