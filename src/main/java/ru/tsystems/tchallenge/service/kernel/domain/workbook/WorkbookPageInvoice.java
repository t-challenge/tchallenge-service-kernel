package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInvoice;

public final class WorkbookPageInvoice extends SearchInvoice {

    private String event;
    private Collection<String> statuses;

    public String getEvent() {
        return event;
    }

    public void setEvent(final String event) {
        this.event = event;
    }

    public Collection<String> getStatuses() {
        return statuses;
    }

    public void setStatuses(final Collection<String> statuses) {
        this.statuses = statuses;
    }
}
