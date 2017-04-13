package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImageMapper;
import ru.tsystems.tchallenge.service.kernel.domain.task.input.CandidateTaskInputMapper;
import ru.tsystems.tchallenge.service.kernel.domain.task.option.CandidateTaskOptionMapper;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippetMapper;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class CandidateTaskMapperBean extends GenericMapper implements CandidateTaskMapper {

    @Autowired
    private CandidateTaskInputMapper taskInputMapper;

    @Autowired
    private CandidateTaskOptionMapper taskOptionMapper;

    @Autowired
    private TaskImageMapper imageMapper;

    @Autowired
    private TaskSnippetMapper snippetMapper;

    @Override
    public CandidateTaskInfoClosed infoClosed(final Task task) {
        return new CandidateTaskInfoClosed(
                task.getTitle(),
                task.getIntroduction(),
                task.getQuestion(),
                task.getExpectation().getId(),
                task.getOptions()
                        .stream()
                        .map(taskOptionMapper::infoClosed)
                        .collect(Collectors.toList()),
                task.getImages()
                        .stream()
                        .map(imageMapper::info)
                        .collect(Collectors.toList()),
                task.getSnippets()
                        .stream()
                        .map(snippetMapper::info)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public CandidateTaskInfoOpened infoOpened(Task task) {
        return new CandidateTaskInfoOpened(
                task.getTitle(),
                task.getIntroduction(),
                task.getQuestion(),
                task.getExpectation().getId(),
                task.getInput() != null ? taskInputMapper.openedInfo(task.getInput()) : null,
                task.getOptions()
                        .stream()
                        .map(taskOptionMapper::infoOpened)
                        .collect(Collectors.toList()),
                task.getImages()
                        .stream()
                        .map(imageMapper::info)
                        .collect(Collectors.toList()),
                task.getSnippets()
                        .stream()
                        .map(snippetMapper::info)
                        .collect(Collectors.toList())
        );
    }
}
