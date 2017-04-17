package ru.tsystems.tchallenge.service.kernel.domain.task;

import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;

public interface EmployeeTaskFacade {

    EmployeeTaskInfo get(Long id);

    SearchInfo<EmployeeTaskInfo> getPage(EmployeeTaskPageInvoice invoice);
}
