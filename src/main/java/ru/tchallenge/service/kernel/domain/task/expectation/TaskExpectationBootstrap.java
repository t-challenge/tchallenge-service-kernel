package ru.tchallenge.service.kernel.domain.task.expectation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskExpectationBootstrap extends EnumeratedEntityBootstrap<TaskExpectation> {

    @Autowired
    private EnumeratedEntityMapper<TaskExpectation> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskExpectation> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("SINGLESELECT", "Одиночный выбор"));
        invoices.add(enumerated("MULTISELECT", "Множественный выбор"));
        invoices.add(enumerated("SMALLINPUT", "Открытый ответ (короткий)"));
        invoices.add(enumerated("LARGEINPUT", "Открытый ответ (обширный)"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskExpectation> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskExpectation> getRepository() {
        return repository;
    }
}
