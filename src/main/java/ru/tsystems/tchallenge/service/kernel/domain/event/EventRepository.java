package ru.tsystems.tchallenge.service.kernel.domain.event;

import ru.tsystems.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface EventRepository extends OrdinalEntityRepository<Event> {

    Event findByTextcode(String textcode);
}
