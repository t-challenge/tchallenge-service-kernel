package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.ArrayList;
import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImageInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.option.CandidateTaskOptionClosedInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippetInfo;

public final class CandidateTaskInfoClosed extends CandidateTaskInfo {

    private final Collection<CandidateTaskOptionClosedInfo> options;

    public CandidateTaskInfoClosed(final String title,
                                   final String introduction,
                                   final String question,
                                   final String expectation,
                                   final Collection<CandidateTaskOptionClosedInfo> options,
                                   final Collection<TaskImageInfo> images,
                                   final Collection<TaskSnippetInfo> snippets) {
        super(title, introduction, question, expectation, images, snippets);
        this.options = new ArrayList<>(options);
    }

    public Collection<CandidateTaskOptionClosedInfo> getOptions() {
        return new ArrayList<>(options);
    }
}
