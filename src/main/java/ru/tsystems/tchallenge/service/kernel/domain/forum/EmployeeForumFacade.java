package ru.tsystems.tchallenge.service.kernel.domain.forum;

import ru.tsystems.tchallenge.service.kernel.generic.page.PageInfo;

public interface EmployeeForumFacade {

    EmployeeForumInfo create(EmployeeForumBlankInvoice invoice);

    EmployeeForumInfo get(String textcode);

    PageInfo<EmployeeForumInfo> getPage(EmployeeForumPageInvoice invoice);

    EmployeeForumInfo update(EmployeeForumUpdateInvoice invoice);
}
