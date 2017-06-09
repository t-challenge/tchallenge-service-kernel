package ru.tsystems.tchallenge.service.kernel.domain.event;

import java.time.Instant;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.domain.event.category.EventCategory;
import ru.tsystems.tchallenge.service.kernel.domain.event.category.EventCategoryBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.event.category.EventCategoryRepository;
import ru.tsystems.tchallenge.service.kernel.domain.event.status.EventStatus;
import ru.tsystems.tchallenge.service.kernel.domain.event.status.EventStatusBootstrap;
import ru.tsystems.tchallenge.service.kernel.domain.event.status.EventStatusRepository;
import ru.tsystems.tchallenge.service.kernel.domain.forum.Forum;
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
        events.add(javaschool21());
    }

    private Event joker2016() {
        final Event event = new Event();
        event.setTextcode("joker2016");
        event.setTitle("Джокер 2016");
        event.setStatus(status("APPROVED"));
        event.setMaturity(maturity("EXPERT"));
        event.getSpecializations().add(specialization("JAVADEV"));
        event.getSpecializations().add(specialization("TESTER"));
        event.setCategory(category("FORUM"));
        event.setForum(new Forum());
        event.setSince(Instant.parse("2016-10-14T09:00:00Z"));
        event.setUntil(Instant.parse("2016-10-15T17:30:00Z"));
        return event;
    }

    private Event findIt2017() {
        final Event event = new Event();
        event.setTextcode("findIt2017");
        event.setTitle("Найти IT 2017");
        event.setStatus(status("APPROVED"));
        event.setMaturity(maturity("JUNIOR"));
        event.getSpecializations().add(specialization("JAVADEV"));
        event.getSpecializations().add(specialization("TESTER"));
        event.setCategory(category("FORUM"));
        event.setForum(new Forum());
        event.setSince(Instant.parse("2017-03-31T09:00:00Z"));
        event.setUntil(Instant.parse("2017-06-01T17:30:00Z"));
        return event;
    }

    private Event heisenbug2017() {
        final Event event = new Event();
        event.setTextcode("heisenbug2017");
        event.setTitle("Гейзенбаг 2017");
        event.setDescription("Для гостей и участников конференции Гейзенбаг 2017");
        event.setGreeting("Примите участие в T-Challenge от T-Systems чтобы получить приз");
        event.setNotification("Приглашаем Вас посетить мастер-класс 'Тщательный подход к техникам тест-дизайна' на стенде T-Systems в 15:00.");
        event.setStatus(status("APPROVED"));
        event.setMaturity(maturity("EXPERT"));
        event.getSpecializations().add(specialization("TESTER"));
        event.setCategory(category("FORUM"));
        event.setForum(new Forum());
        event.setSince(Instant.parse("2017-03-31T09:00:00Z"));
        event.setUntil(Instant.parse("2017-06-05T17:30:00Z"));
        return event;
    }

    private Event javaschool21() {
        final Event event = new Event();
        event.setTextcode("javaschool21");
        event.setTitle("T-Systems Java School 21");
        event.setDescription("Для поступающих в Java-школу от компании T-Systems");
        event.setGreeting("Пройдите тест и получите приглашение на финальное отборочное собеседование с Вашими будущими преподавателями и кураторами");
        event.setStatus(status("APPROVED"));
        event.setMaturity(maturity("EXPERT"));
        event.getSpecializations().add(specialization("JAVADEV"));
        event.setCategory(category("FORUM"));
        event.setForum(new Forum());
        event.setSince(Instant.parse("2017-06-09T00:00:00Z"));
        event.setUntil(Instant.parse("2017-07-01T00:00:00Z"));
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
