package ru.tchallenge.service.kernel.domain.task.input;

public interface TaskInputMapper {

    TaskInput asEntity(TaskInputInvoice invoice);

    TaskInput asEntityMerged(TaskInput entity, TaskInputInvoice invoice);

    TaskInputInfoComplete asInfoComplete(TaskInput entity);
}
