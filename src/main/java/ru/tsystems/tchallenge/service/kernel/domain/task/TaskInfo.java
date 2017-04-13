package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.ArrayList;
import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImageInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippetInfo;
import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public abstract class TaskInfo extends GenericInfo {

    private final String title;
    private final String introduction;
    private final String question;
    private final String expectation;
    private final Collection<TaskImageInfo> images;
    private final Collection<TaskSnippetInfo> snippets;

    public TaskInfo(final String title,
                    final String introduction,
                    final String question,
                    final String expectation,
                    final Collection<TaskImageInfo> images,
                    final Collection<TaskSnippetInfo> snippets) {
        this.title = title;
        this.introduction = introduction;
        this.question = question;
        this.expectation = expectation;
        this.images = new ArrayList<>(images);
        this.snippets = new ArrayList<>(snippets);
    }

    public String getTitle() {
        return title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getQuestion() {
        return question;
    }

    public String getExpectation() {
        return expectation;
    }

    public Collection<TaskImageInfo> getImages() {
        return new ArrayList<>(images);
    }

    public Collection<TaskSnippetInfo> getSnippets() {
        return new ArrayList<>(snippets);
    }
}
