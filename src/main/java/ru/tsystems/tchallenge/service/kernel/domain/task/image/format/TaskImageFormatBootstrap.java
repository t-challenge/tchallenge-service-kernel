package ru.tsystems.tchallenge.service.kernel.domain.task.image.format;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskImageFormatBootstrap extends EnumeratedEntityBootstrap<TaskImageFormat> {

    @Autowired
    private TaskImageFormatRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("GIF");
        ids.add("JPEG");
        ids.add("PNG");
    }

    @Override
    protected TaskImageFormat enumerated(final String id) {
        return new TaskImageFormat(id);
    }

    @Override
    protected GenericEntityRepository<TaskImageFormat, String> getRepository() {
        return repository;
    }
}
