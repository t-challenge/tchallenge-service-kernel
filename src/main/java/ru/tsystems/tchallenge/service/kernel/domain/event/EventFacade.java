package ru.tsystems.tchallenge.service.kernel.domain.event;

import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;

public interface EventFacade {

    EventInfo get(String textcode);

    SearchInfo<EventInfo> search(EventSearchInvoice invoice);
}
