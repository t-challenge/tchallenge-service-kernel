package ru.tchallenge.service.kernel.domain.assignment.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/assignments/statuses")
public class AssignmentStatusController extends EnumeratedEntityController<AssignmentStatus> {

    @Autowired
    private EnumeratedEntityFacade<AssignmentStatus> facade;

    @Override
    protected EnumeratedEntityFacade<AssignmentStatus> getFacade() {
        return facade;
    }
}
