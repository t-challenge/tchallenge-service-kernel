package ru.tchallenge.service.kernel.domain.task.snippet.style;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.EndpointComponent;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@EndpointComponent("/tasks/snippets/formats")
public class TaskSnippetStyleController extends EnumeratedEntityController<TaskSnippetStyle> {

    @Autowired
    private EnumeratedEntityFacade<TaskSnippetStyle> facade;

    @Override
    protected EnumeratedEntityFacade<TaskSnippetStyle> getFacade() {
        return facade;
    }
}
