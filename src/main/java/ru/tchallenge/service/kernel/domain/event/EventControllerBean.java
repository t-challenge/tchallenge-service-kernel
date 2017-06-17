package ru.tchallenge.service.kernel.domain.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tchallenge.service.kernel.generic.GenericController;
import ru.tchallenge.service.kernel.generic.page.SearchInfo;

@RestController
@RequestMapping(path = "/data/events")
public class EventControllerBean extends GenericController {

    private final EventFacade eventFacade;

    @Autowired
    public EventControllerBean(final EventFacade eventFacade) {
        this.eventFacade = eventFacade;
    }

    @RequestMapping(path = "/{textcode}", method = RequestMethod.GET)
    public EventInfo get(@PathVariable("textcode") final String textcode) {
        return eventFacade.get(textcode);
    }

    @RequestMapping(method = RequestMethod.GET)
    public SearchInfo<EventInfo> search(final EventSearchInvoice invoice) {
        return eventFacade.search(invoice);
    }
}
