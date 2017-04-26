package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;

public interface WorkbookFacade {

    WorkbookInfo create(WorkbookInvoice invoice);

    WorkbookInfo get(Long id);

    SearchInfo<WorkbookInfo> getPage(WorkbookPageInvoice invoice);

    WorkbookInfo update(WorkbookInvoice invoice);
}
