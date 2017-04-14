package ru.tsystems.tchallenge.service.kernel.domain.forum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.domain.event.Event;
import ru.tsystems.tchallenge.service.kernel.domain.event.EventBootstrapBean;
import ru.tsystems.tchallenge.service.kernel.domain.event.EventRepository;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.OrdinalEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class ForumBootstrapBean extends OrdinalEntityBootstrap<Forum> {

    @Autowired
    private EventBootstrapBean eventBootstrap;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ForumRepository forumRepository;

    @Override
    protected void collectEntities(Collection<Forum> forums) {
        forums.add(joker2016());
        forums.add(findIt2017());
        forums.add(heisenbug2017());
    }

    @Override
    protected GenericEntityRepository<Forum, Long> getRepository() {
        return forumRepository;
    }

    private Forum joker2016() {
        return forum("joker2016");
    }

    private Forum findIt2017() {
        return forum("findIt2017");
    }

    private Forum heisenbug2017() {
        return forum("heisenbug2017");
    }

    private Forum forum(final String textcode) {
        final Event event = event(textcode);
        final Forum forum = new Forum(event.getId());
        forum.setEvent(event);
        return forum;
    }

    private Event event(final String textcode) {
        return eventRepository.findByTextcode(textcode);
    }
}
