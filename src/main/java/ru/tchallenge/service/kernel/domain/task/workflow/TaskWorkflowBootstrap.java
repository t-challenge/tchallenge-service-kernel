package ru.tchallenge.service.kernel.domain.task.workflow;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskWorkflowBootstrap extends EnumeratedEntityBootstrap<TaskWorkflow> {

    @Autowired
    private EnumeratedEntityMapper<TaskWorkflow> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskWorkflow> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("MACHINE", "Проверяется автоматически"));
        invoices.add(enumerated("EXPERT", "Требуется оценка эксперта"));
        invoices.add(enumerated("MIXED", "Смешанный тип проверки"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskWorkflow> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskWorkflow> getRepository() {
        return repository;
    }
}
