package ru.tsystems.tchallenge.service.kernel.domain.event;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface EventRepository extends OrdinalEntityRepository<Event> {

    Collection<Event> findAll();

    Event findByTextcode(String textcode);
}
