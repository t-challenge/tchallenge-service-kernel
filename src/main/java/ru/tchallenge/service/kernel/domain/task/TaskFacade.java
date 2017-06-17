package ru.tchallenge.service.kernel.domain.task;

import ru.tchallenge.service.kernel.generic.page.SearchInfo;

public interface TaskFacade {

    TaskInfoComplete create(TaskInvoice invoice);

    TaskInfoComplete get(Long id);

    SearchInfo<TaskInfoComplete> search(TaskSearchInvoice invoice);

    TaskInfoComplete update(TaskInvoice invoice);

    TaskInfoComplete updateStatus(TaskInvoice invoice);
}
