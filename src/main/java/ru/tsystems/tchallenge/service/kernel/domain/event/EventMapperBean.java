package ru.tsystems.tchallenge.service.kernel.domain.event;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.domain.forum.ForumMapper;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.Maturity;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.Specialization;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

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
                event.getStatus().getId(),
                event.getMaturities().stream().map(Maturity::getId).collect(Collectors.toList()),
                event.getSpecializations().stream().map(Specialization::getId).collect(Collectors.toList()),
                forumMapper.info(event.getForum())
        );
    }
}
