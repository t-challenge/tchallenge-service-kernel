package ru.tsystems.tchallenge.service.kernel.domain.task.option;

import ru.tsystems.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class CandidateTaskOptionMapperBean extends GenericMapper implements CandidateTaskOptionMapper {

    @Override
    public CandidateTaskOptionClosedInfo infoClosed(final TaskOption option) {
        return new CandidateTaskOptionClosedInfo(
                option.getContent(),
                option.getTextcode()
        );
    }

    @Override
    public CandidateTaskOptionOpenedInfo infoOpened(final TaskOption option) {
        return new CandidateTaskOptionOpenedInfo(
                option.getContent(),
                flag(option.getCorrect()),
                option.getExplanation(),
                option.getTextcode()
        );
    }
}
