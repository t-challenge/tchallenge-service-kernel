package ru.tchallenge.service.kernel.domain.task;

import java.util.Collection;

import ru.tchallenge.service.kernel.domain.task.option.TaskOptionInfoRestricted;

public final class TaskInfoRestricted extends TaskInfo {

    private Collection<TaskOptionInfoRestricted> options;

    public Collection<TaskOptionInfoRestricted> getOptions() {
        return options;
    }

    public void setOptions(Collection<TaskOptionInfoRestricted> options) {
        this.options = options;
    }
}
