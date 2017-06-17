package ru.tchallenge.service.kernel.domain.task.image.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tasks/images/content")
public class TaskImageControllerBean {

    @Autowired
    private TaskImageContentFacade contentFacade;

    @RequestMapping(method = RequestMethod.POST)
    public TaskImageContentInfo create(@RequestBody final byte[] binaryData) {
        return contentFacade.create(invoice(binaryData));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public byte[] get(@PathVariable("id") final String id) {
        return contentFacade.get(id).getBinaryData();
    }

    private TaskImageContentInvoice invoice(final byte[] binaryData) {
        final TaskImageContentInvoice invoice = new TaskImageContentInvoice();
        invoice.setBinaryData(binaryData);
        return invoice;
    }
}
