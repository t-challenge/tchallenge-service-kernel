package ru.tchallenge.service.kernel.domain.event.category;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class EventCategoryFacade extends EnumeratedEntityFacade<EventCategory> {

    @Autowired
    private EnumeratedEntityMapper<EventCategory> mapper;

    @Autowired
    private EnumeratedEntityRepository<EventCategory> repository;

    @Override
    protected EnumeratedEntityMapper<EventCategory> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<EventCategory> getRepository() {
        return repository;
    }
}
