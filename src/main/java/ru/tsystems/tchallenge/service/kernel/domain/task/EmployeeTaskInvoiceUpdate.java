package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.Collection;

public final class EmployeeTaskInvoiceUpdate extends EmployeeTaskInvoice {

    private Long id;
    private String status;
    private Collection<String> fields;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Collection<String> getFields() {
        return fields;
    }

    public void setFields(final Collection<String> fields) {
        this.fields = fields;
    }
}
