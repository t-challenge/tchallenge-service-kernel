package ru.tchallenge.service.kernel.domain.assignment.status;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class AssignmentStatusMapper extends EnumeratedEntityMapper<AssignmentStatus> {

    @Override
    protected AssignmentStatus enumeratedEntity() {
        return new AssignmentStatus();
    }
}
