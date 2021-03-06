package ru.tchallenge.service.kernel.domain.workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.GenericControllerBean;
import ru.tchallenge.service.kernel.generic.page.SearchInfo;

@EndpointComponent("/workbooks")
public class WorkbookControllerBean extends GenericControllerBean {

    private final WorkbookFacade workbookFacade;

    @Autowired
    public WorkbookControllerBean(final WorkbookFacade workbookFacade) {
        this.workbookFacade = workbookFacade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public WorkbookInfo create(@RequestBody final WorkbookInvoice invoice) {
        return workbookFacade.create(invoice);
    }

    @RequestMapping(method = RequestMethod.GET)
    public SearchInfo<WorkbookInfo> getPage(final WorkbookPageInvoice invoice) {
        return workbookFacade.getPage(invoice);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WorkbookInfo get(@PathVariable("id") final Long id) {
        return workbookFacade.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public WorkbookInfo update(@RequestBody final WorkbookInvoice invoice) {
        return workbookFacade.update(invoice);
    }
}
