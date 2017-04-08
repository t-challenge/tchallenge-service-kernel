package ru.tsystems.tchallenge.service.kernel.domain.solution.option;

import ru.tsystems.tchallenge.service.kernel.conventions.MapperService;
import ru.tsystems.tchallenge.service.kernel.generic.GenericMapper;

@MapperService
public class SolutionOptionMapperBean extends GenericMapper implements SolutionOptionMapper {

    @Override
    public SolutionOptionInfoComplete infoComplete(final SolutionOption option) {
        final SolutionOptionInfoComplete info = new SolutionOptionInfoComplete();
        info.setContent(option.getContent());
        info.setCorrect(flag(option.getCorrect()));
        info.setExplanation(option.getExplanation());
        info.setTextcode(option.getTextcode());
        return info;
    }

    @Override
    public SolutionOptionInfoQuiz infoQuiz(final SolutionOption option) {
        final SolutionOptionInfoQuiz info = new SolutionOptionInfoQuiz();
        info.setContent(option.getContent());
        info.setTextcode(option.getTextcode());
        return info;
    }
}
