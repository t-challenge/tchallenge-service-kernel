package ru.tchallenge.service.kernel.domain.maturity;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class MaturityMapper extends EnumeratedEntityMapper<Maturity> {

    @Override
    protected Maturity enumeratedEntity() {
        return new Maturity();
    }
}
