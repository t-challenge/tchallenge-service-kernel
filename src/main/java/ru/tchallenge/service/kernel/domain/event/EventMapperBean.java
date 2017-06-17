package ru.tchallenge.service.kernel.domain.event;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.domain.forum.ForumMapper;
import ru.tchallenge.service.kernel.domain.specialization.Specialization;
import ru.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class EventMapperBean extends GenericMapper implements EventMapper {

    private final ForumMapper forumMapper;

    @Autowired
    public EventMapperBean(final ForumMapper forumMapper) {
        this.forumMapper = forumMapper;
    }

    @Override
    public EventInfo info(final Event event) {
        return new EventInfo(
                event.getTextcode(),
                event.getTitle(),
                event.getDescription(),
                event.getGreeting(),
                event.getNotification(),
                event.getStatus().getId(),
                event.getMaturity().getId(),
                event.getSpecializations().stream().map(Specialization::getId).collect(Collectors.toList()),
                event.getSince(),
                event.getUntil(),
                forumMapper.info(event.getForum())
        );
    }
}
