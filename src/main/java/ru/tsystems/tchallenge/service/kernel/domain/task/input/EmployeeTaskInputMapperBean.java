package ru.tsystems.tchallenge.service.kernel.domain.task.input;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class EmployeeTaskInputMapperBean extends GenericMapper implements EmployeeTaskInputMapper {

    @Override
    public EmployeeTaskInputInfo info(final TaskInput input) {
        return new EmployeeTaskInputInfo(
                input.getContent(),
                input.getExplanation()
        );
    }
}
