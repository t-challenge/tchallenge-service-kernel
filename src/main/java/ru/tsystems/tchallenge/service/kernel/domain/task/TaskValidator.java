package ru.tsystems.tchallenge.service.kernel.domain.task;

public interface TaskValidator {

    TaskInvoice ensureForCreate(TaskInvoice invoice);

    TaskInvoice ensureForUpdate(TaskInvoice invoice);

    TaskInvoice ensureForUpdateStatus(TaskInvoice invoice);
}
