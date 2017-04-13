package ru.tsystems.tchallenge.service.kernel.domain.task.option;

public interface CandidateTaskOptionMapper {

    CandidateTaskOptionClosedInfo infoClosed(TaskOption option);

    CandidateTaskOptionOpenedInfo infoOpened(TaskOption option);
}
