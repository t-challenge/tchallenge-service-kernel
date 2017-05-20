package ru.tsystems.tchallenge.service.kernel.domain.task.image;

public interface TaskImageMapper {

    TaskImage asEntity(TaskImageInvoice invoice);

    TaskImage asEntityMerged(TaskImage entity, TaskImageInvoice invoice);

    TaskImageInfo asInfo(TaskImage entity);
}
