package ru.tchallenge.service.kernel.domain.task.option;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericMapper;

@MapperServiceComponent
public class TaskOptionMapperBean extends GenericMapper implements TaskOptionMapper {

    @Override
    public TaskOption asEntity(TaskOptionInvoice invoice) {
        return asEntityMerged(new TaskOption(), invoice);
    }

    @Override
    public TaskOption asEntityMerged(TaskOption entity, TaskOptionInvoice invoice) {
        entity.setContent(invoice.getContent());
        entity.setExplanation(invoice.getExplanation());
        entity.setTextcode(invoice.getTextcode());
        entity.setCorrect(flag(invoice.getCorrect()));
        return entity;
    }

    @Override
    public TaskOptionInfoComplete asInfoComplete(final TaskOption entity) {
        return new TaskOptionInfoComplete(
                entity.getContent(),
                flag(entity.getCorrect()),
                entity.getExplanation(),
                entity.getTextcode()
        );
    }

    @Override
    public TaskOptionInfoRestricted asInfoRestricted(final TaskOption entity) {
        return new TaskOptionInfoRestricted(
                entity.getContent(),
                entity.getTextcode()
        );
    }
}
