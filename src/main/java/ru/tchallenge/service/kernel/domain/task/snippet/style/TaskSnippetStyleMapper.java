package ru.tchallenge.service.kernel.domain.task.snippet.style;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperService
public class TaskSnippetStyleMapper extends EnumeratedEntityMapper<TaskSnippetStyle> {

    @Override
    protected TaskSnippetStyle enumeratedEntity() {
        return new TaskSnippetStyle();
    }
}
