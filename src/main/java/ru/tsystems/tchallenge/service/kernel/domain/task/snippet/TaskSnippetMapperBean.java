package ru.tsystems.tchallenge.service.kernel.domain.task.snippet;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class TaskSnippetMapperBean extends GenericMapper implements TaskSnippetMapper {

    @Override
    public TaskSnippetInfo info(final TaskSnippet snippet) {
        return new TaskSnippetInfo(
                snippet.getContent(),
                snippet.getStance(),
                snippet.getStyle().getId()
        );
    }
}
