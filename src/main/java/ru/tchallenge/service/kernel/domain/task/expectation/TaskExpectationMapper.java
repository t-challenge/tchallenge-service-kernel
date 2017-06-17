package ru.tchallenge.service.kernel.domain.task.expectation;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskExpectationMapper extends EnumeratedEntityMapper<TaskExpectation> {

    @Override
    protected TaskExpectation enumeratedEntity() {
        return new TaskExpectation();
    }
}
