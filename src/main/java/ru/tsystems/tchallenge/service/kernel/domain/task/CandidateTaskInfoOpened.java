package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.ArrayList;
import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImageInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.input.CandidateTaskInputOpenedInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.option.CandidateTaskOptionOpenedInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippetInfo;

public final class CandidateTaskInfoOpened extends CandidateTaskInfo {

    private final CandidateTaskInputOpenedInfo input;
    private final Collection<CandidateTaskOptionOpenedInfo> options;

    public CandidateTaskInfoOpened(final String title,
                                   final String introduction,
                                   final String question,
                                   final String expectation,
                                   final CandidateTaskInputOpenedInfo input,
                                   final Collection<CandidateTaskOptionOpenedInfo> options,
                                   final Collection<TaskImageInfo> images,
                                   final Collection<TaskSnippetInfo> snippets) {
        super(title, introduction, question, expectation, images, snippets);
        this.input = input;
        this.options = new ArrayList<>(options);
    }

    public Collection<CandidateTaskOptionOpenedInfo> getOptions() {
        return new ArrayList<>(options);
    }
}
