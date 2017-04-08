package ru.tsystems.tchallenge.service.kernel.domain.solution.option;

public interface SolutionOptionMapper {

    SolutionOptionInfoComplete infoComplete(SolutionOption option);

    SolutionOptionInfoQuiz infoQuiz(SolutionOption option);
}
