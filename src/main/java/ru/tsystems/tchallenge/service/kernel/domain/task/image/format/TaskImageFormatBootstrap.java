package ru.tsystems.tchallenge.service.kernel.domain.task.image.format;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskImageFormatBootstrap extends EnumeratedEntityBootstrap<TaskImageFormat> {

    @Autowired
    private EnumeratedEntityMapper<TaskImageFormat> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskImageFormat> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("GIF", "Векторный рисунок (GIF)"));
        invoices.add(enumerated("JPEG", "Растровая графика (JPEG)"));
        invoices.add(enumerated("PNG", "Растровая графика (PNG)"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskImageFormat> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskImageFormat> getRepository() {
        return repository;
    }
}
