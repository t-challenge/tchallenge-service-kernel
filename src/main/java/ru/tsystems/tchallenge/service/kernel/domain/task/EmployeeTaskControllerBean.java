package ru.tsystems.tchallenge.service.kernel.domain.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;
import ru.tsystems.tchallenge.service.kernel.generic.page.PageInfo;

@RestController
@RequestMapping(path = "/data/employees/tasks")
public class EmployeeTaskControllerBean extends GenericController {

    @Autowired
    private EmployeeTaskFacade taskFacade;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public EmployeeTaskInfo get(@PathVariable("id") final Long id) {
        return taskFacade.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageInfo<EmployeeTaskInfo> getPage(final EmployeeTaskPageInvoice invoice) {
        return taskFacade.getPage(pageInvoice(invoice));
    }

    private EmployeeTaskInvoiceBlank invoice(final EmployeeTaskInvoiceBlank invoice) {
        return invoice != null ? invoice : new EmployeeTaskInvoiceBlank();
    }

    private EmployeeTaskPageInvoice pageInvoice(final EmployeeTaskPageInvoice invoice) {
        return invoice != null ? invoice : new EmployeeTaskPageInvoice();
    }

    private EmployeeTaskInvoiceUpdate pageUpdate(final Long id,
                                                 final EmployeeTaskInvoiceUpdate invoice) {
        return invoice != null ? invoice : new EmployeeTaskInvoiceUpdate();
    }
}
