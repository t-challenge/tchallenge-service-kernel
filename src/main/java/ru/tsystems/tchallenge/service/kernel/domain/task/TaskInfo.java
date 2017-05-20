package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.Collection;

import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImageInfo;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippetInfo;
import ru.tsystems.tchallenge.service.kernel.generic.GenericInfo;

public abstract class TaskInfo extends GenericInfo {

    private String introduction;
    private String question;

    private String expectation;

    private Collection<TaskImageInfo> images;
    private Collection<TaskSnippetInfo> snippets;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExpectation() {
        return expectation;
    }

    public void setExpectation(String expectation) {
        this.expectation = expectation;
    }

    public Collection<TaskImageInfo> getImages() {
        return images;
    }

    public void setImages(Collection<TaskImageInfo> images) {
        this.images = images;
    }

    public Collection<TaskSnippetInfo> getSnippets() {
        return snippets;
    }

    public void setSnippets(Collection<TaskSnippetInfo> snippets) {
        this.snippets = snippets;
    }
}
