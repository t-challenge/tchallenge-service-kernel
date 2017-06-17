package ru.tchallenge.service.kernel.domain.event;

import ru.tchallenge.service.kernel.generic.page.SearchInfo;

public interface EventFacade {

    EventInfo get(String textcode);

    SearchInfo<EventInfo> search(EventSearchInvoice invoice);
}
