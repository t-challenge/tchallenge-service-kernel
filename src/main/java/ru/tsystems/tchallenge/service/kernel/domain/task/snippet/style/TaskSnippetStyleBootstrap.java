package ru.tsystems.tchallenge.service.kernel.domain.task.snippet.style;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.BootstrapComponent;
import ru.tsystems.tchallenge.service.kernel.generic.bootstrap.EnumeratedEntityBootstrap;
import ru.tsystems.tchallenge.service.kernel.generic.repository.GenericEntityRepository;

@BootstrapComponent
public class TaskSnippetStyleBootstrap extends EnumeratedEntityBootstrap<TaskSnippetStyle> {

    @Autowired
    private TaskSnippetStyleRepository repository;

    @Override
    protected void collectIds(final Collection<String> ids) {
        ids.add("CONSOLE");
        ids.add("JAVA");
        ids.add("JAVASCRIPT");
        ids.add("HTML");
        ids.add("CSS");
    }

    @Override
    protected TaskSnippetStyle enumerated(final String id) {
        return new TaskSnippetStyle(id);
    }

    @Override
    protected GenericEntityRepository<TaskSnippetStyle, String> getRepository() {
        return repository;
    }
}
