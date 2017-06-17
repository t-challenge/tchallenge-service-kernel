package ru.tchallenge.service.kernel.domain.task;

public interface TaskMapper {

    Task asEntity(TaskInvoice invoice);

    Task asEntityMerged(Task task, TaskInvoice invoice);

    TaskInfoComplete asInfoComplete(Task task);

    TaskInfoRestricted asInfoRestricted(Task task);
}
