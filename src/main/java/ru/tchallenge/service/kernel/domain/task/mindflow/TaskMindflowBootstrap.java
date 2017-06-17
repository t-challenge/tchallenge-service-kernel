package ru.tchallenge.service.kernel.domain.task.mindflow;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskMindflowBootstrap extends EnumeratedEntityBootstrap<TaskMindflow> {

    @Autowired
    private EnumeratedEntityMapper<TaskMindflow> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskMindflow> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("FOUNDATIONS", "Термины и определения"));
        invoices.add(enumerated("ANALYSES", "Анализ"));
        invoices.add(enumerated("BRAINHECK", "Головоломка"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskMindflow> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskMindflow> getRepository() {
        return repository;
    }
}
