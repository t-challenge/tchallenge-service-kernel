package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;

@RestController
@RequestMapping(path = "/data/workbooks")
public class WorkbookControllerBean extends GenericController {

    @RequestMapping(method = RequestMethod.POST)
    public WorkbookInfoComplete create(final WorkbookInvoice invoice) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WorkbookInfoComplete get(@PathVariable("id") final Long id) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(method = RequestMethod.GET)
    public WorkbookInfoComplete getPage(final WorkbookPageInvoice invoice) {
        throw new UnsupportedOperationException();
    }
}
