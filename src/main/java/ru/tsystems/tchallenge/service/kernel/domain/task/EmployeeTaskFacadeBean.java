package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ru.tsystems.tchallenge.service.kernel.conventions.FacadeService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericFacade;
import ru.tsystems.tchallenge.service.kernel.generic.page.SearchInfo;

@FacadeService
public class EmployeeTaskFacadeBean extends GenericFacade implements EmployeeTaskFacade {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeTaskMapper taskMapper;

    @Override
    public EmployeeTaskInfo get(final Long id) {
        return info(byId(id));
    }

    @Override
    public SearchInfo<EmployeeTaskInfo> getPage(final EmployeeTaskPageInvoice invoice) {
        final PageRequest pageRequest = new PageRequest(0, 10);
        final Page<Task> page = taskRepository.findPage(pageRequest);
        final SearchInfo<EmployeeTaskInfo> pageInfo = new SearchInfo<>();
        pageInfo.setSerial(1);
        pageInfo.setSize(10);
        pageInfo.setTotal(page.getTotalPages());
        pageInfo.setItems(page.getContent().stream().map(this::info).collect(Collectors.toList()));
        return pageInfo;
    }

    private EmployeeTaskInfo info(final Task task) {
        return taskMapper.info(task);
    }

    private Task byId(final Long id) {
        return taskRepository.findById(id);
    }
}
