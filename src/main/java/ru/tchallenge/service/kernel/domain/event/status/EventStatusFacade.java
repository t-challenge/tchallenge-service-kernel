package ru.tchallenge.service.kernel.domain.event.status;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class EventStatusFacade extends EnumeratedEntityFacade<EventStatus> {

    @Autowired
    private EnumeratedEntityMapper<EventStatus> mapper;

    @Autowired
    private EnumeratedEntityRepository<EventStatus> repository;

    @Override
    protected EnumeratedEntityMapper<EventStatus> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<EventStatus> getRepository() {
        return repository;
    }
}
