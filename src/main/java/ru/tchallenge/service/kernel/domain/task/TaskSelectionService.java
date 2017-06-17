package ru.tchallenge.service.kernel.domain.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.CommonService;

@CommonService
public class TaskSelectionService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskSelectionInfo create(final TaskSelectionInvoice invoice) {
        final int easyAmount = invoice.getAmount() / 2;
        final int mediumAmount = (invoice.getAmount() - easyAmount) / 2;
        final int hardAmount = invoice.getAmount() - easyAmount - mediumAmount;

        final Collection<Long> easyIds = taskRepository
                .findSelection(invoice.getCategories(), Collections.singleton("EASY"))
                .stream()
                .limit(easyAmount)
                .map(Task::getId)
                .collect(Collectors.toList());

        final List<Long> mediumIds = taskRepository
                .findSelection(invoice.getCategories(), Collections.singleton("MEDIUM"))
                .stream()
                .limit(10)
                .map(Task::getId)
                .collect(Collectors.toList());

        final Collection<Long> hardIds = taskRepository
                .findSelection(invoice.getCategories(), Collections.singleton("HARD"))
                .stream()
                .limit(hardAmount)
                .map(Task::getId)
                .collect(Collectors.toList());

        final TaskSelectionInfo result = new TaskSelectionInfo();
        result.setIds(new ArrayList<>());
        Collections.shuffle(mediumIds);
//        result.getIds().addAll(easyIds);
        result.getIds().addAll(mediumIds.subList(0, 5));
//        result.getIds().addAll(hardIds);
        return result;
    }
}
