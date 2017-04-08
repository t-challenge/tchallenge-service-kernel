package ru.tsystems.tchallenge.service.kernel.domain.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;
import ru.tsystems.tchallenge.service.kernel.generic.page.PageInfo;

@RestController
@RequestMapping(path = "/data/tasks")
public class TaskControllerBean extends GenericController {

    @Autowired
    private TaskFacadeBean taskFacade;

    @RequestMapping(method = RequestMethod.POST)
    public TaskInfo create(@RequestBody final TaskInvoice invoice) {
        return taskFacade.create(invoice);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public TaskInfo getById(@PathVariable("id") final Long id) {
        return taskFacade.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageInfo<TaskInfo> getPage() {
        return taskFacade.getPage(new TaskPageInvoice());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public TaskInfo update(@PathVariable("id") final Long id,
                           @RequestBody final TaskUpdateInvoice invoice) {
        invoice.setId(id);
        return taskFacade.update(invoice);
    }

    @RequestMapping(path = "/{id}/status", method = RequestMethod.PUT)
    public TaskInfo updateStatus(@PathVariable("id") final Long id,
                                 @RequestBody final TaskStatusUpdateInvoice invoice) {
        invoice.setId(id);
        return taskFacade.updateStatus(invoice);
    }
}
