package ru.tsystems.tchallenge.service.kernel.domain.task;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class TaskStatusUpdateInvoice extends GenericInvoice {

    private Long id;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
