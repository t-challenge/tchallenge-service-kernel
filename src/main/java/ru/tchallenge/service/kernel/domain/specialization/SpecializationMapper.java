package ru.tchallenge.service.kernel.domain.specialization;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class SpecializationMapper extends EnumeratedEntityMapper<Specialization> {

    @Override
    protected Specialization enumeratedEntity() {
        return new Specialization();
    }
}
