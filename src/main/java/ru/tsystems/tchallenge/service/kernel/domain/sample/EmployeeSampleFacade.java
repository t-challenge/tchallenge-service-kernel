package ru.tsystems.tchallenge.service.kernel.domain.sample;

import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;

public interface EmployeeSampleFacade {

    EmployeeSampleInfo create(EmployeeSampleInvoice invoice);

    EmployeeSampleInfo get(Long id);

    SearchInfo<EmployeeSampleInfo> getPage(EmployeeSamplePageInvoice invoice);

    EmployeeSampleInfo update(EmployeeSampleUpdateInvoice invoice);
}
