package ru.tsystems.tchallenge.service.kernel.domain.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;
import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;

@RestController
@RequestMapping(path = "/data/tasks")
public class EmployeeTaskControllerBean extends GenericController {

    @Autowired
    private EmployeeTaskFacade taskFacade;

    @RequestMapping(method = RequestMethod.POST)
    public EmployeeTaskInfo create(@RequestBody final EmployeeTaskInvoiceBlank invoiceBlank) {
        return taskFacade.create(invoiceBlank);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public EmployeeTaskInfo update(@RequestBody final EmployeeTaskInvoiceUpdate invoiceUpdate) {
        return taskFacade.update(invoiceUpdate);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public EmployeeTaskInfo get(@PathVariable("id") final Long id) {
        return taskFacade.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public SearchInfo<EmployeeTaskInfo> getPage(final EmployeeTaskPageInvoice invoice) {
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
