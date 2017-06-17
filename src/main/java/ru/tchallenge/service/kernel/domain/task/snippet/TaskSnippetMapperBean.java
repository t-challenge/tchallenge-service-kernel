package ru.tchallenge.service.kernel.domain.task.snippet;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.domain.task.snippet.style.TaskSnippetStyleRepository;
import ru.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class TaskSnippetMapperBean extends GenericMapper implements TaskSnippetMapper {

    @Autowired
    private TaskSnippetStyleRepository styleRepository;

    @Override
    public TaskSnippet asEntity(final TaskSnippetInvoice invoice) {
        return asEntityMerged(new TaskSnippet(), invoice);
    }

    @Override
    public TaskSnippet asEntityMerged(final TaskSnippet entity, final TaskSnippetInvoice invoice) {
        entity.setContent(invoice.getContent());
        entity.setStance(invoice.getStance());
        entity.setStyle(styleRepository.findById(invoice.getStyle()));
        return entity;
    }

    @Override
    public TaskSnippetInfo asInfo(final TaskSnippet snippet) {
        return new TaskSnippetInfo(
                snippet.getContent(),
                snippet.getStance(),
                snippet.getStyle().getId()
        );
    }
}
