package ru.tchallenge.service.kernel.domain.workbook.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/workbooks/statuses")
public class WorkbookStatusController extends EnumeratedEntityController<WorkbookStatus> {

    @Autowired
    private EnumeratedEntityFacade<WorkbookStatus> facade;

    @Override
    protected EnumeratedEntityFacade<WorkbookStatus> getFacade() {
        return facade;
    }
}
