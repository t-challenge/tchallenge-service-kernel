package ru.tsystems.tchallenge.service.kernel.domain.solution.input;

import org.springframework.stereotype.Service;

import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@Service
public class SolutionInputMapperBean extends GenericMapper {

    public SolutionInputInfo info(final SolutionInput input) {
        final SolutionInputInfo info = new SolutionInputInfo();
        info.setContent(input.getContent());
        info.setExplanation(input.getExplanation());
        return info;
    }
}
