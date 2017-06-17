package ru.tchallenge.service.kernel.domain.event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import ru.tchallenge.service.kernel.generic.repository.OrdinalEntityRepository;

public interface EventRepository extends OrdinalEntityRepository<Event> {

    Event findByTextcode(String textcode);

    @Query("SELECT e FROM Event AS e")
    Page<Event> findPage(Pageable pageable);
}
