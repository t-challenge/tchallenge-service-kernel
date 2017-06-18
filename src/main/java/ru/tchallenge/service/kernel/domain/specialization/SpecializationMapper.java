package ru.tchallenge.service.kernel.domain.specialization;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class SpecializationMapper extends EnumeratedEntityMapper<Specialization> {

    @Override
    protected Specialization enumeratedEntity() {
        return new Specialization();
    }
}
