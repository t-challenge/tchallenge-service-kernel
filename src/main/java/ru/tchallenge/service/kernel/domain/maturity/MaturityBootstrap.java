package ru.tchallenge.service.kernel.domain.maturity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class MaturityBootstrap extends EnumeratedEntityBootstrap<Maturity> {

    @Autowired
    private EnumeratedEntityMapper<Maturity> mapper;

    @Autowired
    private EnumeratedEntityRepository<Maturity> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("STUDENT", "Студенты, начало карьеры"));
        invoices.add(enumerated("JUNIOR", "Младшие специалисты"));
        invoices.add(enumerated("INTERMEDIATE", "Специалисты"));
        invoices.add(enumerated("SENIOR", "Старшие специалисты"));
        invoices.add(enumerated("EXPERT", "Экспертный уровень"));
    }

    @Override
    protected EnumeratedEntityMapper<Maturity> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<Maturity> getRepository() {
        return repository;
    }
}
