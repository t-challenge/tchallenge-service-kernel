package ru.tsystems.tchallenge.service.kernel.domain.task;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.domain.account.Account;
import ru.tsystems.tchallenge.service.kernel.domain.employee.Employee;
import ru.tsystems.tchallenge.service.kernel.domain.task.category.TaskCategory;
import ru.tsystems.tchallenge.service.kernel.domain.task.image.TaskImageMapper;
import ru.tsystems.tchallenge.service.kernel.domain.task.input.EmployeeTaskInputMapper;
import ru.tsystems.tchallenge.service.kernel.domain.task.option.EmployeeTaskOptionMapper;
import ru.tsystems.tchallenge.service.kernel.domain.task.snippet.TaskSnippetMapper;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class EmployeeTaskMapperBean extends GenericMapper implements EmployeeTaskMapper {

    @Autowired
    private EmployeeTaskInputMapper taskInputMapper;

    @Autowired
    private EmployeeTaskOptionMapper taskOptionMapper;

    @Autowired
    private TaskImageMapper imageMapper;

    @Autowired
    private TaskSnippetMapper snippetMapper;

    @Override
    public EmployeeTaskInfo info(final Task task) {
        return new EmployeeTaskInfo(
                task.getId(),
                task.getTitle(),
                task.getIntroduction(),
                task.getQuestion(),
                task.getExpectation().getId(),
                task.getImages()
                        .stream()
                        .map(imageMapper::info)
                        .collect(Collectors.toList()),
                task.getSnippets()
                        .stream()
                        .map(snippetMapper::info)
                        .collect(Collectors.toList()),
                task.getStatus().getId(),
                task.getComplexity(),
                task.getCategories().stream()
                        .map(TaskCategory::getId)
                        .collect(Collectors.toList()),
                task.getDifficulty().getId(),
                task.getOwnership().getId(),
                task.getWorkflow().getId(),
                task.getInput() != null ? taskInputMapper.info(task.getInput()) : null,
                task.getOptions().stream()
                        .map(taskOptionMapper::info)
                        .collect(Collectors.toList()),
                task.getAuthors().stream()
                        .map(Employee::getAccount)
                        .map(Account::getLogin)
                        .collect(Collectors.toList()),
                task.getMindflow().getId(),
                task.getCreatedBy().getAccount().getLogin(),
                task.getCreatedAt(),
                task.getModifiedAt());
    }
}
