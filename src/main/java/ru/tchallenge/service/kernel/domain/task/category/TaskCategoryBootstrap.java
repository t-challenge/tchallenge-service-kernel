package ru.tchallenge.service.kernel.domain.task.category;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskCategoryBootstrap extends EnumeratedEntityBootstrap<TaskCategory> {

    @Autowired
    private EnumeratedEntityMapper<TaskCategory> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskCategory> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("COMMON", "Общая логика"));
        invoices.add(enumerated("JAVA", "Java"));
        invoices.add(enumerated("JAVASCRIPT", "JavaScript"));
        invoices.add(enumerated("SQL", "SQL и базы данных"));
        invoices.add(enumerated("TEST", "Тестирование программного обеспечения"));
        invoices.add(enumerated("HTML", "Веб-верстка (HTML)"));
        invoices.add(enumerated("CSS", "Каскадные таблицы стилей CSS"));
        invoices.add(enumerated("OOD", "Объектно-ориентированное программирование"));
        invoices.add(enumerated("THREADS", "Многопоточное программирование"));
        invoices.add(enumerated("ALGORITHMS", "Алгоритмы"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskCategory> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskCategory> getRepository() {
        return repository;
    }
}
