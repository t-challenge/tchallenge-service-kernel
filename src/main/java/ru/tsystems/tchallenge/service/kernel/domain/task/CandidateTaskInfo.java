package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImageInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippetInfo;

public abstract class CandidateTaskInfo extends TaskInfo {

    public CandidateTaskInfo(final String title,
                             final String introduction,
                             final String question,
                             final String expectation,
                             final Collection<TaskImageInfo> images,
                             final Collection<TaskSnippetInfo> snippets) {
        super(title, introduction, question, expectation, images, snippets);
    }
}
