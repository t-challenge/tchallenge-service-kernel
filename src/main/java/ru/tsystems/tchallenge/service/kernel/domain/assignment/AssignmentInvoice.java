package ru.tsystems.tchallenge.service.kernel.domain.assignment;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class AssignmentInvoice extends GenericInvoice {

    private String id;
    private String input;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
