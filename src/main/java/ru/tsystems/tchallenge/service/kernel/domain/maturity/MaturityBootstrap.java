package ru.tsystems.tchallenge.service.kernel.domain.maturity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class MaturityBootstrap extends EnumeratedEntityBootstrap<Maturity> {

    @Autowired
    private MaturityRepository repository;

    @Override
    protected void collectIds(final Collection<String> maturities) {
        maturities.add("STUDENT");
        maturities.add("JUNIOR");
        maturities.add("INTERMEDIATE");
        maturities.add("SENIOR");
        maturities.add("EXPERT");
    }

    @Override
    protected Maturity enumerated(final String id) {
        return new Maturity(id);
    }

    @Override
    protected GenericEntityRepository<Maturity, String> getRepository() {
        return repository;
    }
}
