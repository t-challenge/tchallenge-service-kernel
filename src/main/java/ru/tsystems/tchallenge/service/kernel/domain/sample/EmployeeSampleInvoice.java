package ru.tsystems.tchallenge.service.kernel.domain.sample;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInvoice;

public final class EmployeeSampleInvoice extends GenericInvoice {

    private String title;
    private String employeeOnlyText;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployeeOnlyText() {
        return employeeOnlyText;
    }

    public void setEmployeeOnlyText(String employeeOnlyText) {
        this.employeeOnlyText = employeeOnlyText;
    }
}
