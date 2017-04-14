package ru.tsystems.tchallenge.service.kernel.domain.event;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.domain.event.category.EventCategory;
import ru.tsystems.tchallenge.service.kernel.domain.event.category.EventCategoryBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.event.category.EventCategoryRepository;
import ru.tsystems.tchallenge.service.kernel.domain.event.status.EventStatus;
import ru.tsystems.tchallenge.service.kernel.domain.event.status.EventStatusBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.event.status.EventStatusRepository;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.Maturity;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.MaturityBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.MaturityRepository;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.Specialization;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.SpecializationBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.SpecializationRepository;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.OrdinalEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class EventBootstrapBean extends OrdinalEntityBootstrap<Event> {

    @Autowired
    private EventCategoryBootstrap categoryBootstrap;

    @Autowired
    private EventStatusBootstrap statusBootstrap;

    @Autowired
    private MaturityBootstrap maturityBootstrap;

    @Autowired
    private SpecializationBootstrap specializationBootstrap;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCategoryRepository categoryRepository;

    @Autowired
    private EventStatusRepository statusRepository;

    @Autowired
    private MaturityRepository maturityRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Override
    protected void collectEntities(final Collection<Event> events) {
        events.add(joker2016());
        events.add(findIt2017());
        events.add(heisenbug2017());
    }

    private Event joker2016() {
        final Event event = new Event();
        event.setTextcode("joker2016");
        event.setTitle("Джокер 2016");
        event.setStatus(status("APPROVED"));
        event.getMaturities().add(maturity("JUNIOR"));
        event.getMaturities().add(maturity("INTERMEDIATE"));
        event.getMaturities().add(maturity("EXPERT"));
        event.getSpecializations().add(specialization("JAVADEV"));
        event.getSpecializations().add(specialization("TESTER"));
        event.setCategory(category("FORUM"));
        return event;
    }

    private Event findIt2017() {
        final Event event = new Event();
        event.setTextcode("findIt2017");
        event.setTitle("Найти IT 2017");
        event.setStatus(status("APPROVED"));
        event.getMaturities().add(maturity("STUDENT"));
        event.getMaturities().add(maturity("JUNIOR"));
        event.getSpecializations().add(specialization("JAVADEV"));
        event.getSpecializations().add(specialization("TESTER"));
        event.setCategory(category("FORUM"));
        return event;
    }

    private Event heisenbug2017() {
        final Event event = new Event();
        event.setTextcode("heisenbug2017");
        event.setTitle("Heisen-Bug 2017");
        event.setStatus(status("CREATED"));
        event.getMaturities().add(maturity("INTERMEDIATE"));
        event.getMaturities().add(maturity("EXPERT"));
        event.getSpecializations().add(specialization("TESTER"));
        event.setCategory(category("FORUM"));
        return event;
    }

    private Event event(final String textcode,
                        final String title,
                        final String status) {
        final Event event = new Event();
        event.setTextcode(textcode);
        event.setTitle(title);
        event.setDescription("some description");
        event.setGreeting("some greeting");
        event.setStatus(status(status));
        event.getMaturities().add(maturity("STUDENT"));
        return event;
    }

    @Override
    protected GenericEntityRepository<Event, Long> getRepository() {
        return eventRepository;
    }

    private EventCategory category(final String id) {
        return categoryRepository.findById(id);
    }

    private EventStatus status(final String id) {
        return statusRepository.findById(id);
    }

    private Maturity maturity(final String id) {
        return maturityRepository.findById(id);
    }

    private Specialization specialization(final String id) {
        return specializationRepository.findById(id);
    }
}
