package ru.tchallenge.service.kernel.domain.task.image;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericMapper;

@MapperServiceComponent
public class TaskImageMapperBean extends GenericMapper implements TaskImageMapper {

    @Override
    public TaskImage asEntity(TaskImageInvoice invoice) {
        return null;
    }

    @Override
    public TaskImage asEntityMerged(TaskImage entity, TaskImageInvoice invoice) {
        return null;
    }

    @Override
    public TaskImageInfo asInfo(final TaskImage entity) {
        return new TaskImageInfo(
                entity.getContent(),
                entity.getDescription(),
                entity.getFormat().getId(),
                entity.getHeight(),
                entity.getHeight(),
                entity.getStance());
    }
}
