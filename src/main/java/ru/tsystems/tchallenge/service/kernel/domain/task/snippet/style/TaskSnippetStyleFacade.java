package ru.tsystems.tchallenge.service.kernel.domain.task.snippet.style;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tsystems.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tsystems.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

@CommonService
public class TaskSnippetStyleFacade extends EnumeratedEntityFacade<TaskSnippetStyle> {

    @Autowired
    private EnumeratedEntityMapper<TaskSnippetStyle> mapper;

    @Autowired
    private EnumeratedEntityRepository<TaskSnippetStyle> repository;

    @Override
    protected EnumeratedEntityMapper<TaskSnippetStyle> getMapper() {
        return mapper;
    }

    @Override
    protected EnumeratedEntityRepository<TaskSnippetStyle> getRepository() {
        return repository;
    }
}
