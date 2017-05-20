package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.components.CommonService;

@CommonService
public class TaskSelectionService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskSelectionInfo create(final TaskSelectionInvoice invoice) {
        final TaskSelectionInfo result = new TaskSelectionInfo();
        result.setIds(taskRepository
                .findAll()
                .stream()
                .limit(invoice.getAmount())
                .map(Task::getId)
                .collect(Collectors.toList()));
        return result;
    }
}
