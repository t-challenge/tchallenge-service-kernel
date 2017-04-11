package ru.tsystems.tchallenge.service.kernel.domain.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;
import ru.tsystems.tchallenge.service.kernel.generic.page.PageInfo;

@RestController
@RequestMapping(path = "/data/employees/samples")
public class EmployeeSampleControllerBean extends GenericController {

    @Autowired
    private EmployeeSampleFacade sampleFacade;

    @RequestMapping(method = RequestMethod.POST)
    public EmployeeSampleInfo create(@RequestBody final EmployeeSampleInvoice invoice) {
        return sampleFacade.create(invoice);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public EmployeeSampleInfo get(@PathVariable("id") final Long id) {
        return sampleFacade.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageInfo<EmployeeSampleInfo> getPage(final EmployeeSamplePageInvoice invoice) {
        return sampleFacade.getPage(invoice);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public EmployeeSampleInfo update(@RequestBody final EmployeeSampleUpdateInvoice invoice) {
        return sampleFacade.update(invoice);
    }
}
