package ru.tsystems.tchallenge.service.kernel.domain.assignment.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/assignments/statuses")
public class AssignmentStatusController extends EnumeratedEntityController<AssignmentStatus> {

    @Autowired
    private EnumeratedEntityFacade<AssignmentStatus> facade;

    @Override
    protected EnumeratedEntityFacade<AssignmentStatus> getFacade() {
        return facade;
    }
}
