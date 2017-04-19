package ru.tsystems.tchallenge.service.kernel.domain.event;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;
import ru.tsystems.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tsystems.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

@FacadeService
public class EventFacadeBean extends GenericFacade implements EventFacade {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final AccessValidationExceptionEmitter accessValidationExceptionEmitter;

    @Autowired
    public EventFacadeBean(final EventRepository eventRepository,
                           final EventMapper eventMapper,
                           final AccessValidationExceptionEmitter accessValidationExceptionEmitter) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.accessValidationExceptionEmitter = accessValidationExceptionEmitter;
    }

    @Override
    public EventInfo get(final String textcode) {
        final AuthenticationInfo authentication = getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        return info(eventRepository.findByTextcode(textcode));
    }

    @Override
    public SearchInfo<EventInfo> search(final EventSearchInvoice invoice) {
        final AuthenticationInfo authentication = getSecurityContext().getAuthentication();
        if (authentication == null) {
            accessValidationExceptionEmitter.unauthorized();
        }
        final SearchInfo<EventInfo> searchInfo = new SearchInfo<>();
        searchInfo.setItems(eventRepository.findAll().stream().map(this::info).collect(Collectors.toList()));
        return searchInfo;
    }

    private EventInfo info(final Event event) {
        return eventMapper.info(event);
    }
}
