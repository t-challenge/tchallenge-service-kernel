package ru.tsystems.tchallenge.service.kernel.domain.task.image.content;

public interface TaskImageContentFacade {

    TaskImageContentInfo create(TaskImageContentInvoice invoice);

    TaskImageContentInfo get(String id);
}
