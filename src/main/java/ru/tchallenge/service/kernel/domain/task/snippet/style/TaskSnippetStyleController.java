package ru.tchallenge.service.kernel.domain.task.snippet.style;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.tchallenge.service.kernel.generic.EnumeratedEntityController;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;

@RestController
@RequestMapping(path = "/tasks/snippets/formats")
public class TaskSnippetStyleController extends EnumeratedEntityController<TaskSnippetStyle> {

    @Autowired
    private EnumeratedEntityFacade<TaskSnippetStyle> facade;

    @Override
    protected EnumeratedEntityFacade<TaskSnippetStyle> getFacade() {
        return facade;
    }
}
