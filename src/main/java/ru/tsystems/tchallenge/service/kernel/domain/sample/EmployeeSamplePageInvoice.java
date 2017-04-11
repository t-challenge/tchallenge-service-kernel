package ru.tsystems.tchallenge.service.kernel.domain.sample;

import ru.tsystems.tchallenge.service.kernel.generic.page.PageInvoice;

public final class EmployeeSamplePageInvoice extends PageInvoice {

    private String title;
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
