package ru.tsystems.tchallenge.service.kernel.domain.task.snippet.style;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class TaskSnippetStyleBootstrap extends EnumeratedEntityBootstrap<TaskSnippetStyle> {

    @Autowired
    private EnumeratedEntityMapper<TaskSnippetStyle> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskSnippetStyle> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("GENERIC", "Базовый стиль"));
        invoices.add(enumerated("CONSOLE", "Вывод консоли"));
        invoices.add(enumerated("JAVA", "Java код"));
        invoices.add(enumerated("JAVASCRIPT", "JavaScript/ECMA скрипт"));
        invoices.add(enumerated("HTML", "HTML документ"));
        invoices.add(enumerated("CSS", "Каскадные таблицы стилей CSS"));
        invoices.add(enumerated("SQL", "SQL запрос"));
    }

    @Override
    protected EnumeratedEntityMapper<TaskSnippetStyle> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskSnippetStyle> getRepository() {
        return repository;
    }
}
