package ru.tchallenge.service.kernel.domain.event;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import ru.tchallenge.service.kernel.conventions.components.FacadeServiceComponent;
import ru.tchallenge.service.kernel.generic.GenericFacade;
import ru.tchallenge.service.kernel.generic.page.SearchInfo;
import ru.tchallenge.service.kernel.security.authentication.AuthenticationInfo;
import ru.tchallenge.service.kernel.validation.access.AccessValidationExceptionEmitter;

@FacadeServiceComponent
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
        return info(eventRepository.findByTextcode(textcode));
    }

    @Override
    public SearchInfo<EventInfo> search(final EventSearchInvoice invoice) {
        final AuthenticationInfo authentication = getSecurityContext().getAuthentication();
        return searchInfo(eventRepository.findPage(pageRequest(invoice)));
    }

    private SearchInfo<EventInfo> searchInfo(final Page<Event> eventPage) {
        final SearchInfo<EventInfo> searchInfo = new SearchInfo<>();
        searchInfo.setItems(eventPage.getContent().stream().map(this::info).collect(Collectors.toList()));
        searchInfo.setTotal(eventPage.getTotalPages());
        return searchInfo;
    }

    private Pageable pageRequest(final EventSearchInvoice invoice) {
        return new PageRequest(invoice.getStance() - 1, invoice.getSize());
    }

    private EventInfo info(final Event event) {
        return eventMapper.info(event);
    }
}
