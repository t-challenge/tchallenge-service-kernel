package ru.tchallenge.service.kernel.domain.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.GenericControllerBean;

@EndpointComponent("/assignments")
public class AssignmentControllerBean extends GenericControllerBean {

    @Autowired
    private AssignmentFacade assignmentFacade;

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody final AssignmentInvoice invoice) {
        assignmentFacade.update(invoice);
    }
}
