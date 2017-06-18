package ru.tchallenge.service.kernel.domain.task.snippet.style;

import ru.tchallenge.service.kernel.conventions.components.MapperServiceComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;

@MapperServiceComponent
public class TaskSnippetStyleMapper extends EnumeratedEntityMapper<TaskSnippetStyle> {

    @Override
    protected TaskSnippetStyle enumeratedEntity() {
        return new TaskSnippetStyle();
    }
}
