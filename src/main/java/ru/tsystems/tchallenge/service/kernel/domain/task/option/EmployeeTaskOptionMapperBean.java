package ru.tsystems.tchallenge.service.kernel.domain.task.option;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class EmployeeTaskOptionMapperBean extends GenericMapper implements EmployeeTaskOptionMapper {

    @Override
    public EmployeeTaskOptionInfo info(final TaskOption option) {
        return new EmployeeTaskOptionInfo(
                option.getContent(),
                flag(option.getCorrect()),
                option.getExplanation(),
                option.getTextcode()
        );
    }
}
