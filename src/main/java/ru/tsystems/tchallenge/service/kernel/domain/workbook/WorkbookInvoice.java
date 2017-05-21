package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class WorkbookInvoice extends GenericInvoice {

    private Long id;
    private String event;
    private String maturity;
    private String specialization;
    private String status;
    private String flashback;

    public String getFlashback() {
        return flashback;
    }

    public void setFlashback(String flashback) {
        this.flashback = flashback;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(final String event) {
        this.event = event;
    }

    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(final String maturity) {
        this.maturity = maturity;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(final String specialization) {
        this.specialization = specialization;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
