package ru.tchallenge.service.kernel.domain.event.status;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class EventStatusMapper extends EnumeratedEntityMapper<EventStatus> {

    @Override
    protected EventStatus enumeratedEntity() {
        return new EventStatus();
    }
}
