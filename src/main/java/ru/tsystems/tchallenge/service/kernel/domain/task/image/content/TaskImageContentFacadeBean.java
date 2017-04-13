package ru.tsystems.tchallenge.service.kernel.domain.task.image.content;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;

@FacadeService
public class TaskImageContentFacadeBean extends GenericFacade implements TaskImageContentFacade {

    @Autowired
    private TaskImageContentRepository contentRepository;

    @Override
    public TaskImageContentInfo create(final TaskImageContentInvoice invoice) {
        final TaskImageContent content = new TaskImageContent();
        content.setBinaryData(invoice.getBinaryData());
        contentRepository.save(content);
        return info(content);
    }

    @Override
    public TaskImageContentInfo get(final String id) {
        return info(contentRepository.findById(id));
    }

    private TaskImageContentInfo info(final TaskImageContent content) {
        return new TaskImageContentInfo(
                content.getId(),
                content.getBinaryData(),
                content.getCreatedAt());
    }
}

