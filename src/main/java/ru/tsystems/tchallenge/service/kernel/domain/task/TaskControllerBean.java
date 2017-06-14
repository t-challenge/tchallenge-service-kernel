package ru.tsystems.tchallenge.service.kernel.domain.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tsystems.tchallenge.service.kernel.generic.GenericController;
import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;

@RestController
@RequestMapping(path = "/tasks")
public class TaskControllerBean extends GenericController {

    @Autowired
    private TaskFacade taskFacade;

    @RequestMapping(method = RequestMethod.POST)
    public TaskInfoComplete create(@RequestBody final TaskInvoice invoice) {
        return taskFacade.create(invoice);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public TaskInfoComplete get(@PathVariable("id") final Long id) {
        return taskFacade.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public SearchInfo<TaskInfoComplete> search(final TaskSearchInvoice invoice) {
        return taskFacade.search(invoice);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public TaskInfoComplete update(@RequestBody final TaskInvoice invoice) {
        return taskFacade.update(invoice);
    }

    @RequestMapping(path = "/status", method = RequestMethod.PUT)
    public TaskInfoComplete updateStatus(@RequestBody final TaskInvoice invoice) {
        return taskFacade.updateStatus(invoice);
    }
}
