package ru.tchallenge.service.kernel.domain.workbook.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/workbooks/statuses")
public class WorkbookStatusController extends EnumeratedEntityController<WorkbookStatus> {

    @Autowired
    private EnumeratedEntityFacade<WorkbookStatus> facade;

    @Override
    protected EnumeratedEntityFacade<WorkbookStatus> getFacade() {
        return facade;
    }
}
