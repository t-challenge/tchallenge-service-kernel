package ru.tsystems.tchallenge.service.kernel.domain.specialization;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class SpecializationMapper extends EnumeratedEntityMapper<Specialization> {

    @Override
    protected Specialization enumeratedEntity() {
        return new Specialization();
    }
}
