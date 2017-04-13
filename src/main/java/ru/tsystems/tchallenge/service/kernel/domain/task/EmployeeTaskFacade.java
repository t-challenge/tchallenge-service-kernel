package ru.tsystems.tchallenge.service.kernel.domain.task;

import ru.tsystems.tchallenge.service.kernel.generic.page.PageInfo;

public interface EmployeeTaskFacade {

    EmployeeTaskInfo get(Long id);

    PageInfo<EmployeeTaskInfo> getPage(EmployeeTaskPageInvoice invoice);
}
