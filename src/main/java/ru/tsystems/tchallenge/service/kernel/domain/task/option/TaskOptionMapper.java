package ru.tsystems.tchallenge.service.kernel.domain.task.option;

public interface TaskOptionMapper {

    TaskOption asEntity(TaskOptionInvoice invoice);

    TaskOption asEntityMerged(TaskOption entity, TaskOptionInvoice invoice);

    TaskOptionInfoComplete asInfoComplete(TaskOption entity);

    TaskOptionInfoRestricted asInfoRestricted(TaskOption entity);
}
