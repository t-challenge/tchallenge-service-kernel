package ru.tsystems.tchallenge.service.kernel.domain.specialization;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class SpecializationBootstrap extends EnumeratedEntityBootstrap<Specialization> {

    @Autowired
    private SpecializationRepository repository;

    @Override
    protected void collectIds(final Collection<String> specializations) {
        specializations.add("JAVADEV");
        specializations.add("TESTER");
    }

    @Override
    protected Specialization enumerated(final String id) {
        return new Specialization(id);
    }

    @Override
    protected GenericEntityRepository<Specialization, String> getRepository() {
        return repository;
    }
}
