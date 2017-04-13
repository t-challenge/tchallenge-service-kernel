package ru.tsystems.tchallenge.service.kernel.domain.task.input;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class CandidateTaskInputMapperBean extends GenericMapper implements CandidateTaskInputMapper {

    @Override
    public CandidateTaskInputOpenedInfo openedInfo(final TaskInput input) {
        return new CandidateTaskInputOpenedInfo(
                input.getContent(),
                input.getExplanation()
        );
    }
}
