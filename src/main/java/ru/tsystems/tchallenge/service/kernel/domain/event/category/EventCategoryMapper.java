package ru.tsystems.tchallenge.service.kernel.domain.event.category;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class EventCategoryMapper extends EnumeratedEntityMapper<EventCategory> {

    @Override
    protected EventCategory enumeratedEntity() {
        return new EventCategory();
    }
}
