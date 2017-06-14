package ru.tsystems.tchallenge.service.kernel.domain.specialization;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedInvoice;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@BootstrapComponent
public class SpecializationBootstrap extends EnumeratedEntityBootstrap<Specialization> {

    @Autowired
    private EnumeratedEntityMapper<Specialization> mapper;

    @Autowired
    private EnumeratedEntityRepository<Specialization> repository;

    @Override
    protected void collectInvoices(Collection<EnumeratedInvoice> invoices) {
        invoices.add(enumerated("JAVADEV", "Разработчик на Java"));
        invoices.add(enumerated("TESTER", "Инженер по тестированию"));
    }

    @Override
    protected EnumeratedEntityMapper<Specialization> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<Specialization> getRepository() {
        return repository;
    }
}
