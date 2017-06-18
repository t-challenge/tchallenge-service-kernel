package ru.tchallenge.service.kernel.domain.assignment.status;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class AssignmentStatusMapper extends EnumeratedEntityMapper<AssignmentStatus> {

    @Override
    protected AssignmentStatus enumeratedEntity() {
        return new AssignmentStatus();
    }
}
