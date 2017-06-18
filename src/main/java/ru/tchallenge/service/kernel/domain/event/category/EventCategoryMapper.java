package ru.tchallenge.service.kernel.domain.event.category;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class EventCategoryMapper extends EnumeratedEntityMapper<EventCategory> {

    @Override
    protected EventCategory enumeratedEntity() {
        return new EventCategory();
    }
}
