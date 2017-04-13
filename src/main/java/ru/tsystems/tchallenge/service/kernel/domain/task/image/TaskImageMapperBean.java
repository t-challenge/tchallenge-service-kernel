package ru.tsystems.tchallenge.service.kernel.domain.task.image;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class TaskImageMapperBean extends GenericMapper implements TaskImageMapper {

    @Override
    public TaskImageInfo info(final TaskImage image) {
        return new TaskImageInfo(
                image.getContent(),
                image.getDescription(),
                image.getFormat().getId(),
                image.getHeight(),
                image.getHeight(),
                image.getStance());
    }
}
