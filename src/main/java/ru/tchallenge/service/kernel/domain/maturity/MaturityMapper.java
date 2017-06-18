package ru.tchallenge.service.kernel.domain.maturity;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class MaturityMapper extends EnumeratedEntityMapper<Maturity> {

    @Override
    protected Maturity enumeratedEntity() {
        return new Maturity();
    }
}
