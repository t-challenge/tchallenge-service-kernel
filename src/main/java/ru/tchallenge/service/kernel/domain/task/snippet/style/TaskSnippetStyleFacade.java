package ru.tchallenge.service.kernel.domain.task.snippet.style;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.CommonService;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityMapper;
import ru.tchallenge.service.kernel.generic.EnumeratedEntityFacade;
import ru.tchallenge.service.kernel.generic.repository.EnumeratedEntityRepository;

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
