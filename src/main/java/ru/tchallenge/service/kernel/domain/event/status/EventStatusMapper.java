package ru.tchallenge.service.kernel.domain.event.status;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class EventStatusMapper extends EnumeratedEntityMapper<EventStatus> {

    @Override
    protected EventStatus enumeratedEntity() {
        return new EventStatus();
    }
}
