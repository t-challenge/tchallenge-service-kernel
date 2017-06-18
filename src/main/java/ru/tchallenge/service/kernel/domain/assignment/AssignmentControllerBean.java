package ru.tchallenge.service.kernel.domain.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tchallenge.service.kernel.generic.GenericControllerBean;

@RestController
@RequestMapping(path = "/assignments")
public class AssignmentControllerBean extends GenericControllerBean {

    @Autowired
    private AssignmentFacade assignmentFacade;

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody final AssignmentInvoice invoice) {
        assignmentFacade.update(invoice);
    }
}
