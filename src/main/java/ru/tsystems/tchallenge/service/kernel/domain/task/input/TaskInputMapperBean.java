package ru.tsystems.tchallenge.service.kernel.domain.task.input;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class TaskInputMapperBean extends GenericMapper implements TaskInputMapper {

    @Override
    public TaskInput asEntity(TaskInputInvoice invoice) {
        return asEntityMerged(new TaskInput(), invoice);
    }

    @Override
    public TaskInput asEntityMerged(TaskInput entity, TaskInputInvoice invoice) {
        entity.setContent(invoice.getContent());
        entity.setExplanation(invoice.getExplanation());
        return entity;
    }

    @Override
    public TaskInputInfoComplete asInfoComplete(final TaskInput entity) {
        return new TaskInputInfoComplete(
                entity.getContent(),
                entity.getExplanation()
        );
    }
}
