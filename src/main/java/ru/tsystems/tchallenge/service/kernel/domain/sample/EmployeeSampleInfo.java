package ru.tsystems.tchallenge.service.kernel.domain.sample;

import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public final class EmployeeSampleInfo extends GenericInfo {

    private Long id;
    private String title;
    private String employeeOnlyText;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
