package ru.tchallenge.service.kernel.domain.task.workflow;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class TaskWorkflowMapper extends EnumeratedEntityMapper<TaskWorkflow> {

    @Override
    protected TaskWorkflow enumeratedEntity() {
        return new TaskWorkflow();
    }
}
